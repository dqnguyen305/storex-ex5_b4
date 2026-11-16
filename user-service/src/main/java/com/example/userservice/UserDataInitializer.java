package com.example.userservice;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDataInitializer implements ApplicationRunner {

    private final UserAccountRepository repository;

    public UserDataInitializer(UserAccountRepository repository) {
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
                new UserAccount("Nguyen Van An", "an@example.com", "CUSTOMER"),
                new UserAccount("Tran Thi Binh", "binh@example.com", "CUSTOMER"),
                new UserAccount("Le Quang Cuong", "cuong@example.com", "RESTAURANT_OWNER"),
                new UserAccount("Pham Thu Dung", "dung@example.com", "CUSTOMER"),
                new UserAccount("Hoang Minh Em", "em@example.com", "ADMIN")));
    }
}
