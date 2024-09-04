package com.app.controller;

import com.app.domain.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Log4j2
public class OrderServiceController {

    private final List<Order> orders = new ArrayList<>();

    @GetMapping("/v1/orders")
    public List<Order> getAllOrders() {
        log.info("returning all order details");
        return orders;
    }

    @GetMapping("/v1/orders/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        log.info("returning order by id");
        return orders.stream().filter(order -> Objects.equals(order.getOrderId(), id)).findFirst().orElse(null);
    }


    @PostMapping("/v1/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        log.info("adding order with details {}", order);
        orders.add(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
