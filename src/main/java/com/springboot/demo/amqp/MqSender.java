package com.springboot.demo.amqp;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 16:29:39
 * @since 1.0
 */
@Service
public class MqSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    @SuppressWarnings("all")
    private MqLogMapper mqLogMapper;

    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData);
            if (ack) {
                System.out.println("this message has been send");
            } else {
                MqLog mqLog = mqLogMapper.getMqLog(Long.parseLong(Objects.requireNonNull(correlationData.getId())));
                if (mqLog.getRetryCount() > 3) {
                    mqLogMapper.updateMqLogStatus(mqLog.getUniId());
                }
                System.out.println("this message need retry");
            }
        }
    };

    public void send(Object data) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.convertAndSend("trusty_topic", "trusty","this is the data " + data);
    }

}
