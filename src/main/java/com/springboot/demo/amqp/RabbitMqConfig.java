package com.springboot.demo.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

import java.util.HashMap;


/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 16:22:09
 * @since 1.0
 */
@Configuration
public class RabbitMqConfig {
//    @Bean
//    public Queue queue() {
//        return new Queue("trusty_queue", true);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange("trusty_topic", true, false);
//    }
//
//    @Bean
//    public Binding bindingBuilder() {
//        return BindingBuilder.bind(queue()).to(exchange()).with("trusty");
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }


//    @Bean
//    public RetryOperationsInterceptor interceptor() {
//        return RetryInterceptorBuilder
//                .stateless()
//                .maxAttempts(5)
//                .backOffOptions(1000, 2, 5000)
//                .recoverer(new RetryMessageRecover())
//                .build();
//    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/mean");
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }

    /**
     * description
     * 0. autoStartup一定要设置为true，否则Spring容器不会加载RabbitAdmin
     *
     * 1. 底层实现就是从Spring容器转中获取Exchange、Binding、Routing以及Queue的@Bean声明
     *
     * 2. 然后使用rabbitTemplate的execute方法执行对应的声明、修改、删除等一系列rabbitmq基础功能操作
     *
     * @author liugangping
     * @date 2019/10/26 11:23
     * @param connectionFactory:上面的connectionFactory
     * @return org.springframework.amqp.rabbit.core.RabbitAdmin
     **/
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        // autoStartup一定要设置为true，否则Spring容器不会加载RabbitAdmin
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public DirectExchange testDirect() {
        return new DirectExchange("test.direct", false, false);
    }

    @Bean
    public TopicExchange testTopic() {
        return new TopicExchange("test.topic", false, false);
    }

    @Bean
    public FanoutExchange testFanout() {
        return new FanoutExchange("test.fanout", false, false);
    }

    @Bean
    public Queue testDirectQueue() {
        return new Queue("test.direct.queue", false);
    }

    @Bean
    public Queue testTopicQueue() {
        return new Queue("test.topic.queue", false);
    }

    @Bean
    public Queue testFanoutQueue() {
        return new Queue("test.fanout.queue", false);
    }

    @Bean
    public Binding bindDirect() {
        return new Binding(testDirectQueue().getName(), Binding.DestinationType.QUEUE,
                testDirect().getName(), "direct", new HashMap<>(0));
    }

    @Bean
    public Binding bindTopic() {
        return BindingBuilder.bind(testTopicQueue()).to(testTopic()).with("topic.*");
    }

    @Bean
    public Binding bingFanout() {
        return BindingBuilder.bind(testFanoutQueue()).to(testFanout());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

//    @Autowired
//    private RabbitProperties rabbitProperties;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost(rabbitProperties.getHost());
//        connectionFactory.setPort(rabbitProperties.getPort());
//        connectionFactory.setUsername(rabbitProperties.getUsername());
//        connectionFactory.setPassword(rabbitProperties.getPassword());
//        connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
//        connectionFactory.setConnectionTimeout(1000);
//        return connectionFactory;
//    }
//
//    @Bean
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory());
//        factory.setMessageConverter(jackson2JsonMessageConverter());
//        factory.setAdviceChain(interceptor());
//        return factory;
//    }
}
