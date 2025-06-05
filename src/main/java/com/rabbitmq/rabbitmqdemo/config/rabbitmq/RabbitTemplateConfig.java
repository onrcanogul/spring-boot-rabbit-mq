package com.rabbitmq.rabbitmqdemo.config.rabbitmq;

import com.rabbitmq.rabbitmqdemo.messaging.MetadataHeaderProcessor;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTemplateConfig {
    private final RabbitTemplate rabbitTemplate;
    private final MetadataHeaderProcessor metadataHeaderProcessor;

    public RabbitTemplateConfig(RabbitTemplate rabbitTemplate, MetadataHeaderProcessor metadataHeaderProcessor) {
        this.rabbitTemplate = rabbitTemplate;
        this.metadataHeaderProcessor = metadataHeaderProcessor;
    }

    @PostConstruct
    public void init() {
        rabbitTemplate.setBeforePublishPostProcessors(metadataHeaderProcessor);
    }
}
