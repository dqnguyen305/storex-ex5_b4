package com.example.notificationservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationRepository repository;
    private final NotificationDataInitializer initializer;

    public NotificationController(NotificationRepository repository, NotificationDataInitializer initializer) {
        this.repository = repository;
        this.initializer = initializer;
    }

    @GetMapping
    public List<Notification> getNotifications() {
        initializer.initializeIfEmpty();
        return repository.findAll();
    }
}
