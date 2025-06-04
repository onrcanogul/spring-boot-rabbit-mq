package com.rabbitmq.rabbitmqdemo.service.producer;

import com.rabbitmq.rabbitmqdemo.event.OrderCreatedEvent;
import com.rabbitmq.rabbitmqdemo.event.OrderDeletedEvent;
import com.rabbitmq.rabbitmqdemo.event.OrderUpdatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


import java.util.UUID;

import static com.rabbitmq.rabbitmqdemo.constant.RabbitMQConstants.*;

@Service
public class OrderProducer {
    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void createOrder(String orderMessage) {
        OrderCreatedEvent event = new OrderCreatedEvent(orderMessage);
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_CREATED_ROUTING_KEY, event);
        System.out.println("Order created sent to queue");
    }

    public void deleteOrder(UUID id) {
        OrderDeletedEvent orderDeletedEvent = new OrderDeletedEvent(id.toString());
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_DELETED_ROUTING_KEY, orderDeletedEvent);
        System.out.println("Order deleted sent to queue");
    }

    public void updateOrder(int quantity) {
        OrderUpdatedEvent orderUpdatedEvent = new OrderUpdatedEvent(quantity);
        rabbitTemplate.convertAndSend(EXCHANGE,  ORDER_UPDATED_ROUTING_KEY, orderUpdatedEvent);
        System.out.println("Order updated sent to queue");
    }
}
