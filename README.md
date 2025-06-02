This project is a message-driven notification system built with Spring Boot and RabbitMQ.
It simulates real-world event publishing by sending different types of order-related messages (order.created, order.updated, order.deleted) to a topic exchange,which are then routed to a shared queue. A single consumer processes the messages based on their routing keys.

The goal of the project is to demonstrate the fundamentals of asynchronous communication in microservices, routing key–based message handling, and clean message consumption logic.
It also explores safe handling of different data types like integers and UUIDs within messages, and prepares the system for advanced concepts like Dead Letter Queues (DLQ), retry mechanisms, and JSON-based messaging via DTOs.

This setup is ideal for learning and extending into a production-grade, fault-tolerant architecture involving Outbox/Inbox patterns and message traceability.

![image](https://github.com/user-attachments/assets/79e1660f-bc38-486b-8d8c-ca6b48516144)
![image](https://github.com/user-attachments/assets/cc13300d-2b79-4349-82cc-20457399bda8)
![image](https://github.com/user-attachments/assets/3a9d05bb-9d85-46b1-9bf0-b2b20b9bf646)


