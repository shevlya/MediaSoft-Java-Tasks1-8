package com.task.practice_assignment.config;

import com.task.practice_assignment.model.CuisineType;
import com.task.practice_assignment.model.Restaurant;
import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.model.Visitor;
import com.task.practice_assignment.service.RestaurantService;
import com.task.practice_assignment.service.ReviewService;
import com.task.practice_assignment.service.VisitorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @PostConstruct
    public void init(){
        Visitor visitor1 = new Visitor(1L, "Misha", 23, "M");
        Visitor visitor2 = new Visitor(2L, "Liza", 22, "F");
        visitorService.save(visitor1);
        visitorService.save(visitor2);

        Restaurant restaurant1 = new Restaurant(1L, "Slon", "Italian cuisine", CuisineType.ITALIAN, BigDecimal.valueOf(2000), null);
        Restaurant restaurant2 = new Restaurant(2L, "List", "European cuisine", CuisineType.EUROPEAN, BigDecimal.valueOf(1600), null);
        restaurantService.save(restaurant1);
        restaurantService.save(restaurant2);

        Review review1 = new Review(visitor1.getId(), restaurant1.getId(), 3, "Very slow");
        Review review2 = new Review(visitor2.getId(), restaurant2.getId(), 5, "Good food");
        reviewService.save(review1);
        reviewService.save(review2);

        restaurantService.updateRating(restaurant1.getId());
        restaurantService.updateRating(restaurant2.getId());

        Review review3 = new Review(visitor2.getId(), restaurant1.getId(), 5, null);
        reviewService.save(review3);
        restaurantService.updateRating(restaurant1.getId());
    }
}
