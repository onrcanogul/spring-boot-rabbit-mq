package com.rabbitmq.rabbitmqdemo.event;

public class OrderCreatedEvent {
    private String orderMessage;

    public OrderCreatedEvent(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }
}
