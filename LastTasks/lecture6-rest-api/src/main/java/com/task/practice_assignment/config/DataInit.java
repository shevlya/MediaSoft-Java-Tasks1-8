package com.task.practice_assignment.config;

import com.task.practice_assignment.dto.RestaurantRequestDTO;
import com.task.practice_assignment.dto.ReviewRequestDTO;
import com.task.practice_assignment.dto.VisitorRequestDTO;
import com.task.practice_assignment.model.CuisineType;
import com.task.practice_assignment.model.Restaurant;
import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.model.Visitor;
import com.task.practice_assignment.service.RestaurantService;
import com.task.practice_assignment.service.ReviewService;
import com.task.practice_assignment.service.VisitorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DataInit {
    private final VisitorService visitorService;
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;

    @PostConstruct
    public void init() {
        visitorService.createVisitor(new VisitorRequestDTO(16, "F", "Lika"));
        visitorService.createVisitor(new VisitorRequestDTO(27, "M", "Jarik"));
        RestaurantRequestDTO dto1 = new RestaurantRequestDTO("Дом пиццы", "Пицца для друзей", CuisineType.ITALIAN, BigDecimal.valueOf(2000));
        Restaurant restaurant1 = restaurantService.createManual(dto1, 1L); // добавим этот метод
        RestaurantRequestDTO dto2 = new RestaurantRequestDTO("В гостях у дяди", "Китайская кухня", CuisineType.CHINESE, BigDecimal.valueOf(1234));
        restaurantService.createManual(dto2, 2L);
        reviewService.create(new ReviewRequestDTO(1L, 1L, 4, "Вкусно, приду с друзьями"));
        reviewService.create(new ReviewRequestDTO(2L, 1L, 5, "Замечательно"));
    }

}
