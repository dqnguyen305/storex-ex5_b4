package com.example.orderservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class CustomerOrderController {

    private final CustomerOrderRepository repository;
    private final OrderDataInitializer initializer;

    public CustomerOrderController(CustomerOrderRepository repository, OrderDataInitializer initializer) {
        this.repository = repository;
        this.initializer = initializer;
    }

    @GetMapping
    public List<CustomerOrder> getOrders() {
        initializer.initializeIfEmpty();
        return repository.findAll();
    }
}
