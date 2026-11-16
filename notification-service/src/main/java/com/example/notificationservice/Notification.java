package com.example.notificationservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private String status;

    protected Notification() {
    }

    public Notification(String recipient, String message, String channel, String status) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getChannel() {
        return channel;
    }

    public String getStatus() {
        return status;
    }
}
