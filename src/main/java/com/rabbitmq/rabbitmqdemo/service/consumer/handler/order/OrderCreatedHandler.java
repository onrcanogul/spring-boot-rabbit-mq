package com.rabbitmq.rabbitmqdemo.service.consumer.handler.order;

import com.rabbitmq.rabbitmqdemo.service.consumer.handler.MessageHandler;
import org.springframework.stereotype.Component;

@Component("order.created")
public class OrderCreatedHandler implements MessageHandler {
    @Override
    public void handle(String body) {
        System.out.println("Order Created: " + body);
    }

    @Override
    public String getRoutingKey() {
        return "order.created";
    }
}
