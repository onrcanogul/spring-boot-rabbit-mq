package com.rabbitmq.rabbitmqdemo.service.consumer.handler.order;

import com.rabbitmq.rabbitmqdemo.service.consumer.handler.MessageHandler;
import org.springframework.stereotype.Component;

@Component("order.deleted")
public class OrderDeletedHandler implements MessageHandler {
    @Override
    public void handle(String body) {
        System.out.println("Order Deleted: " + body);
    }

    @Override
    public String getRoutingKey() {
        return "order.deleted";
    }
}
