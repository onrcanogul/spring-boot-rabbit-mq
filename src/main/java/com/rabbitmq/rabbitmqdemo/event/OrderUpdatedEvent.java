package com.rabbitmq.rabbitmqdemo.event;

public class OrderUpdatedEvent {
    private int quantity;


    public OrderUpdatedEvent(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
