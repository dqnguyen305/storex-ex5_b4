package com.example.userservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountRepository repository;
    private final UserDataInitializer initializer;

    public UserAccountController(UserAccountRepository repository, UserDataInitializer initializer) {
        this.repository = repository;
        this.initializer = initializer;
    }

    @GetMapping
    public List<UserAccount> getUsers() {
        initializer.initializeIfEmpty();
        return repository.findAll();
    }
}
