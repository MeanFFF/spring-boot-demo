package com.springboot.demo.amqp;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 16:36:57
 * @since 1.0
 */
@Component
@RabbitListener(queues = "trusty_queue")
public class MqListener {
    @Autowired
    @SuppressWarnings("all")
    private MqLogMapper mqLogMapper;

    private static final Integer RETRY_COUNT = 3;

    @RabbitHandler
    public void consumer(@Payload MqLog mqLog, @Headers Map headers, Channel channel) throws IOException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        long messageId = (long) headers.get("uniId");
        boolean requeue = true;
        try {

            System.out.println("this is msg " + mqLog);
            throw new RuntimeException("消费错误");
        } catch (Exception e) {
            System.out.println("this message has been consume failed");
            MqLog mqLog1 = mqLogMapper.getMqLog(messageId);
            if (mqLog1.getRetryCount() > RETRY_COUNT) {
                mqLogMapper.updateMqLogStatus(mqLog1.getUniId(), -1);
                requeue = false;
            }
            channel.basicNack(deliveryTag, false, requeue);
        }
        channel.basicAck(deliveryTag, false);
    }
}
