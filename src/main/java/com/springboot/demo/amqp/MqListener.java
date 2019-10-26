package com.springboot.demo.amqp;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
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

    @RabbitHandler
    public void consumer(String msg, @Headers Map headers, Channel channel) throws IOException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            System.out.println("this is msg " + msg);
            int a = 1/0;
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            System.out.println("this message has been consume failed");
            channel.basicNack(deliveryTag, false, true);
        }

    }
}
