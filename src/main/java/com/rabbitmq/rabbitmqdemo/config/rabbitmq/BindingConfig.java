package com.rabbitmq.rabbitmqdemo.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rabbitmq.rabbitmqdemo.constant.RabbitMQConstants.*;

@Configuration
public class BindingConfig {

    @Bean
    public Binding orderCreatedbinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_CREATED_ROUTING_KEY);
    }

    @Bean
    public Binding orderDeletedbinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_DELETED_ROUTING_KEY);
    }

    @Bean
    public Binding orderUpdatedbinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_UPDATED_ROUTING_KEY);
    }

    @Bean
    public Binding dlqBinding(Queue orderDlqQueue, TopicExchange orderDlxExchange) {
        return BindingBuilder.bind(orderDlqQueue).to(orderDlxExchange).with(ORDER_DLQ_ROUTING_KEY);
    }
}
