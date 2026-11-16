package com.example.restaurantservice;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RestaurantDataInitializer implements ApplicationRunner {

    private final RestaurantRepository repository;

    public RestaurantDataInitializer(RestaurantRepository repository) {
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
                new Restaurant("Pho Saigon", "Vietnamese", "12 Nguyen Trai, Ho Chi Minh City", 4.7),
                new Restaurant("Bun Bo Hue Co Ba", "Vietnamese", "25 Le Loi, Hue", 4.5),
                new Restaurant("Sushi Haru", "Japanese", "8 Tran Phu, Da Nang", 4.6),
                new Restaurant("The Green Bowl", "Healthy", "41 Xuan Dieu, Hanoi", 4.4),
                new Restaurant("Pizza Corner", "Italian", "19 Hai Ba Trung, Can Tho", 4.3)));
    }
}
