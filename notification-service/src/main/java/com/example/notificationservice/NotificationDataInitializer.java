package com.example.notificationservice;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NotificationDataInitializer implements ApplicationRunner {

    private final NotificationRepository repository;

    public NotificationDataInitializer(NotificationRepository repository) {
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
                new Notification("an@example.com", "Your order has been delivered.", "EMAIL", "SENT"),
                new Notification("binh@example.com", "Your order is being prepared.", "PUSH", "SENT"),
                new Notification("cuong@example.com", "A new order has been placed.", "EMAIL", "SENT"),
                new Notification("dung@example.com", "Your order is on the way.", "SMS", "SENT"),
                new Notification("em@example.com", "Your order has been confirmed.", "PUSH", "PENDING")));
    }
}
