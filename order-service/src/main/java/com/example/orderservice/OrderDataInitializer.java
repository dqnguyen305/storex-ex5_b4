package com.example.orderservice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderDataInitializer implements ApplicationRunner {

    private final CustomerOrderRepository repository;

    public OrderDataInitializer(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        initializeIfEmpty();
    }

    @Transactional
    public void initializeIfEmpty() {
        if (repository.count() > 0) {
            return;
        }

        repository.saveAll(List.of(
                new CustomerOrder("Nguyen Van An", "Pho Saigon", "DELIVERED", new BigDecimal("125000")),
                new CustomerOrder("Tran Thi Binh", "Sushi Haru", "PREPARING", new BigDecimal("245000")),
                new CustomerOrder("Le Quang Cuong", "Pizza Corner", "CONFIRMED", new BigDecimal("189000")),
                new CustomerOrder("Pham Thu Dung", "The Green Bowl", "DELIVERING", new BigDecimal("99000")),
                new CustomerOrder("Hoang Minh Em", "Bun Bo Hue Co Ba", "PENDING", new BigDecimal("85000"))));
    }
}
