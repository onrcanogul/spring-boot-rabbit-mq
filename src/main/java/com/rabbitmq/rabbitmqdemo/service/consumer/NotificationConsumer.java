package com.rabbitmq.rabbitmqdemo.service.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.rabbitmqdemo.service.consumer.handler.HandlerService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    private final HandlerService handlerService;

    public NotificationConsumer(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @RabbitListener(queues = "order-queue")
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public void onMessage(Message message, Channel channel) throws Exception {
        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        String messageId = message.getMessageProperties().getMessageId();
        String appId = message.getMessageProperties().getAppId();
        String queue = message.getMessageProperties().getConsumerQueue();
        String correlationId = message.getMessageProperties().getCorrelationId();

        String body = new String(message.getBody());

        System.out.println("Notification Received");

        System.out.println("Routing Key: " +  routingKey);
        System.out.println("Message Id: " +  messageId);
        System.out.println("App Id: " +  appId);
        System.out.println("Queue: " +  queue);
        System.out.println("Correlation Id: " +  correlationId);

        System.out.println("*************************************************");

        // TEST DLQ -> channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

        handlerService.getHandler(routingKey)
                .ifPresentOrElse(
                        handler -> handler.handle(body),
                        () -> System.out.println("No handler found for routing key: " + routingKey) );

    }
}
