package com.rabbitmq.rabbitmqdemo.service.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DLQConsumer {

    @RabbitListener(queues = "order-dlq-queue")
    public void onMessage(Message message) {
        System.out.println("DLQ Message received: " + new String(message.getBody()));
        //logging, retry, insert...
    }
}
