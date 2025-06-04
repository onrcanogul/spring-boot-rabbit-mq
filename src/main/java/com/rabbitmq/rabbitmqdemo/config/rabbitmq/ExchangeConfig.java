package com.rabbitmq.rabbitmqdemo.config.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rabbitmq.rabbitmqdemo.constant.RabbitMQConstants.*;

@Configuration
public class ExchangeConfig {

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public TopicExchange orderDlxExchange() {
        return new TopicExchange(ORDER_DLQ_EXCHANGE);
    }
}