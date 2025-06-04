package com.rabbitmq.rabbitmqdemo.constant;

public class RabbitMQConstants {
    public static final String QUEUE = "order-queue";
    public static final String DLQ_QUEUE = "order-dlq-queue";
    public static final String EXCHANGE = "order-exchange";
    public static final String ORDER_DLQ_EXCHANGE = "order-dlx-exchange";
    public static final String ORDER_CREATED_ROUTING_KEY = "order.created";
    public static final String ORDER_DELETED_ROUTING_KEY = "order.deleted";
    public static final String ORDER_UPDATED_ROUTING_KEY = "order.updated";
    public static final String ORDER_DLQ_ROUTING_KEY = "order.dlq";


    public static final String RETRY_QUEUE = "order-retry-queue";
    public static final String RETRY_EXCHANGE = "order-retry-exchange";
    public static final String RETRY_ROUTING_KEY = "order.retry";
}
