package com.task.practice_assignment.config;

import com.task.practice_assignment.service.RestaurantService;
import com.task.practice_assignment.service.ReviewService;
import com.task.practice_assignment.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestRunner implements CommandLineRunner {
    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @Override
    public void run(String... args) {

        System.out.println("\nПосетители:");
        visitorService.findAll().forEach(System.out::println);

        System.out.println("\nРестораны:");
        restaurantService.findAll().forEach(System.out::println);

        System.out.println("\nОтзывы:");
        reviewService.findAll().forEach(System.out::println);

        System.out.println("\nРейтинг ресторана с ID 1: " + restaurantService.findById(1L).getRating());
    }
}
