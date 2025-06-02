package com.rabbitmq.rabbitmqdemo.service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


import java.util.UUID;

import static com.rabbitmq.rabbitmqdemo.config.RabbitMQConfig.*;

@Service
public class OrderProducer {
    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createOrder(String orderMessage) {
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_CREATED_ROUTING_KEY, orderMessage);
        System.out.println("Order created sent to queue");
    }

    public void deleteOrder(UUID id) {
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_DELETED_ROUTING_KEY, id.toString());
        System.out.println("Order deleted sent to queue");
    }

    public void updateOrder(int quantity) {
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_UPDATED_ROUTING_KEY, String.valueOf(quantity));
        System.out.println("Order updated sent to queue");
    }
}
