package com.rabbitmq.rabbitmqdemo.service.consumer.handler;

public interface MessageHandler {
    void handle(String body);
    String getRoutingKey();
}
