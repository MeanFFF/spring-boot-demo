package com.springboot.demo.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
    @Bean
    public Queue queue() {
        return new Queue("trusty_queue", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("trusty_topic", true, false);
    }

    @Bean
    public Binding bindingBuilder() {
        return BindingBuilder.bind(queue()).to(exchange()).with("trusty");
    }
}
