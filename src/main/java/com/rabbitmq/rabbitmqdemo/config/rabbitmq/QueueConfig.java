package com.rabbitmq.rabbitmqdemo.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.rabbitmq.rabbitmqdemo.constant.RabbitMQConstants.*;

@Configuration
public class QueueConfig {

    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", ORDER_DLQ_EXCHANGE);
        args.put("x-dead-letter-routing-key", ORDER_DLQ_ROUTING_KEY);
        return new Queue(QUEUE, true, false, true, args);
    }

    @Bean
    public Queue orderDlqQueue() {
        return new Queue(DLQ_QUEUE);
    }
}
