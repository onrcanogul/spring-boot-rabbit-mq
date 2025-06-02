This project is a message-driven notification system built with Spring Boot and RabbitMQ.
It simulates real-world event publishing by sending different types of order-related messages (order.created, order.updated, order.deleted) to a topic exchange,which are then routed to a shared queue. A single consumer processes the messages based on their routing keys.

The goal of the project is to demonstrate the fundamentals of asynchronous communication in microservices, routing key–based message handling, and clean message consumption logic.
It also explores safe handling of different data types like integers and UUIDs within messages, and prepares the system for advanced concepts like Dead Letter Queues (DLQ), retry mechanisms, and JSON-based messaging via DTOs.

This setup is ideal for learning and extending into a production-grade, fault-tolerant architecture involving Outbox/Inbox patterns and message traceability.
