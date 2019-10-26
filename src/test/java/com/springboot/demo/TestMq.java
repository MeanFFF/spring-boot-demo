package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 16:42:18
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMq {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    /**
     * description RabbitAdmin组件的使用
     * @author liugangping
     * @date 2019/10/26 14:03
     * @param []
     * @return void
     **/
    @Test
    public void testAdmin() {
        rabbitAdmin.declareExchange(new DirectExchange("test.direct", false, false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic", false, false));
        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout", false, false));

        rabbitAdmin.declareQueue(new Queue("test.direct.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue", false));

        rabbitAdmin.declareBinding(new Binding("test.direct.queue", Binding.DestinationType.QUEUE,
                "test.direct", "direct", new HashMap<>()));

        // 使用BindingBuilder生成绑定
        rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue("test.topic.queue", false))
                .to(new TopicExchange("test.topic", false, false))
                .with("topic"));

        rabbitAdmin.declareBinding(
                BindingBuilder.bind(new Queue("test.fanout.queue", false))
                .to(new FanoutExchange("test.fanout", false, false)));

        // 清空队列中的消息
        rabbitAdmin.purgeQueue("test.topic");
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "新增描述");
        Message message = new Message("Hello world".getBytes(), messageProperties);

        rabbitTemplate.convertAndSend("test.topic", "topic.amqp", message, msg -> {
                // 还是在发送之前
                System.out.println("后置操作");
                msg.getMessageProperties().getHeaders().put("desc", "修改描述");
                return msg;
            });
        /**
         Exchange	    test.topic
         Routing Key	topic.amqp
         Redelivered	○
         Properties
                priority:	    0
                delivery_mode:	2
                headers:
                    desc:	        修改描述
                    content_type:	application/octet-stream
         Payload
         11 bytes
         Encoding: string
                Hello world
         */
    }

    @Test
    public void testSendMessageEasy() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentEncoding("utf-8");
        messageProperties.setContentType("text/plain");
        Message message = new Message("Hello 1234".getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("test.topic", "topic.amqp", message);
        /**
         * Exchange	    test.topic
         * Routing Key	topic.amqp
         * Redelivered	○
         * Properties
         *      priority:	    0
         *      delivery_mode:	2
         *      headers:
         *          content_encoding:	utf-8
         *          content_type:	    text/plain
         * Payload
         * 10 bytes
         * Encoding: string
         *      Hello 1234
         **/
        rabbitTemplate.convertAndSend("test.topic", "topic.amqp", "hello hello");
        /**
         * Exchange	    test.topic
         * Routing Key	topic.amqp
         * Redelivered	○
         * Properties
         *      priority:	    0
         *      delivery_mode:	2
         *      headers:
         *          content_encoding:	UTF-8
         *          content_type:	text/plain
         * Payload
         * 11 bytes
         * Encoding: string
         *      hello hello
         **/

    }
}
