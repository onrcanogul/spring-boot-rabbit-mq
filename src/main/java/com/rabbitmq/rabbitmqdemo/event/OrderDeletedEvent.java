package com.rabbitmq.rabbitmqdemo.event;

public class OrderDeletedEvent {
    private String orderId;

    public OrderDeletedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
