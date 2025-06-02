package com.rabbitmq.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "order-queue";
    public static final String DLQ_QUEUE = "order-dlq-queue";
    public static final String EXCHANGE = "order-exchange";
    public static final String ORDER_DLQ_EXCHANGE = "order-dlx-exchange";
    public static final String ORDER_CREATED_ROUTING_KEY = "order.created";
    public static final String ORDER_DELETED_ROUTING_KEY = "order.deleted";
    public static final String ORDER_UPDATED_ROUTING_KEY = "order.updated";
    public static final String ORDER_DLQ_ROUTING_KEY = "order.dlq";


    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", ORDER_DLQ_EXCHANGE); // DLQ exchange
        args.put("x-dead-letter-routing-key", ORDER_DLQ_ROUTING_KEY); // DLQ routing key
        // args.put("x-max-length", 1000); reject over 1000 messages
        // args.put("x-message-ttl", 60000); TTL per message
        // args.put("x-expires", 600000); expire if empty for 10mins
        return new Queue(QUEUE, true, false, true, args);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

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
    public Queue orderDlqQueue() {
        return new Queue(DLQ_QUEUE);
    }

    @Bean
    public TopicExchange orderDlxExchange() {
        return new TopicExchange(ORDER_DLQ_EXCHANGE);
    }

    @Bean
    public Binding dlqBinding() {
        return BindingBuilder.bind(orderDlqQueue()).to(orderDlxExchange()).with(ORDER_DLQ_ROUTING_KEY);
    }
}
