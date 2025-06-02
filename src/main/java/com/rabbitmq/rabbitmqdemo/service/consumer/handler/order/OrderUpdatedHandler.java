package com.rabbitmq.rabbitmqdemo.service.consumer.handler.order;

import com.rabbitmq.rabbitmqdemo.service.consumer.handler.MessageHandler;
import org.springframework.stereotype.Component;

@Component("order.updated")
public class OrderUpdatedHandler implements MessageHandler {
    @Override
    public void handle(String body) {
        System.out.println("Order's new quantity: " + body);
    }

    @Override
    public String getRoutingKey() {
        return "order.updated";
    }
}
