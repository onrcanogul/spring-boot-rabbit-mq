package com.rabbitmq.rabbitmqdemo.controller;

import com.rabbitmq.rabbitmqdemo.service.producer.OrderProducer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderProducer orderService;

    public OrderController(OrderProducer orderService) {
        this.orderService = orderService;
    }

    @GetMapping("create/{message}") // get method for easy testing :)
    public void createOrder(@PathVariable String message) {
        orderService.createOrder(message);
    }

    @GetMapping("update/{quantity}") // get method for easy testing :)
    public void updateOrder(@PathVariable int quantity) {
        orderService.updateOrder(quantity);
    }

    @GetMapping("delete/{id}") // get method for easy testing :)
    public void deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
    }
}
