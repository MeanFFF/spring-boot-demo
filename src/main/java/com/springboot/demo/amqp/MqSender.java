package com.springboot.demo.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    @Autowired
    private ObjectMapper objectMapper;

    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData);
            String messageId = correlationData.getId();
            if (ack) {
                assert messageId != null;
                mqLogMapper.updateMqLogStatus(Long.parseLong(messageId), 1);
                System.out.println("this message has been send");
            } else {
                System.out.println("this message need retry");
            }
        }
    };

    public void send(MqLog mqLog) {
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(String.valueOf(mqLog.getUniId()));
        Message message = null;
        try {
            message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(mqLog))
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .setContentEncoding("utf-8")
                    .setMessageId(UUID.randomUUID()+"")
                    .setHeader("uniId", mqLog.getUniId())
                    .build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend("trusty_topic", "trusty",message, correlationData);
    }

}
