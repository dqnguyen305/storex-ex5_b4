package com.example.restaurantservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantRepository repository;
    private final RestaurantDataInitializer initializer;

    public RestaurantController(RestaurantRepository repository, RestaurantDataInitializer initializer) {
        this.repository = repository;
        this.initializer = initializer;
    }

    @GetMapping
    public List<Restaurant> getRestaurants() {
        initializer.initializeIfEmpty();
        return repository.findAll();
    }
}
