package com.rabbitmq.rabbitmqdemo.service.consumer.handler;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class HandlerService {
    private final List<MessageHandler> handlers;
    private final Map<String, MessageHandler> handlerMap = new HashMap<>();

    public HandlerService(List<MessageHandler> handlers) {
        this.handlers = handlers;
    }

    @PostConstruct
    public void init() {
        for (MessageHandler messageHandler : handlers) {
            handlerMap.put(messageHandler.getRoutingKey(), messageHandler);
        }
    }

    public Optional<MessageHandler> getHandler(String routingKey) {
        return Optional.ofNullable(handlerMap.get(routingKey));
    }
}
