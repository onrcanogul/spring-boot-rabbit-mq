package com.rabbitmq.rabbitmqdemo.service.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.rabbitmqdemo.event.OrderCreatedEvent;
import com.rabbitmq.rabbitmqdemo.event.OrderDeletedEvent;
import com.rabbitmq.rabbitmqdemo.event.OrderUpdatedEvent;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RabbitListener(queues = "order-queue")
public class NotificationConsumer {

    @RabbitHandler
    public void handleCreated(OrderCreatedEvent event) {
        System.out.println("Handling Order Created: " + event.getOrderMessage());
    }

    @RabbitHandler
    public void handleUpdated(OrderUpdatedEvent event, Channel channel, Message message) throws IOException {
        if (event.getQuantity() < 0) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false); // -> to DLQ
            //throw new Exception() -> Retry
        }
        System.out.println("Handling Order Updated: " + event.getQuantity());
    }

    @RabbitHandler
    public void handleDeleted(OrderDeletedEvent event) {
        System.out.println("Handling Order Deleted: " + event.getOrderId());
    }

    // Optional fallback
    @RabbitHandler(isDefault = true)
    public void handleUnknown(Object obj) {
        System.out.println("Unknown event type: " + obj);
    }
}

