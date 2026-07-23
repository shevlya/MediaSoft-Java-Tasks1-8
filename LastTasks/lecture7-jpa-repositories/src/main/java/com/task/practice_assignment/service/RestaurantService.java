package com.task.practice_assignment.service;

import com.task.practice_assignment.model.Restaurant;
import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.repository.RestaurantRepository;
import com.task.practice_assignment.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public void save(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }
    public void remove(Restaurant restaurant){
        restaurantRepository.remove(restaurant);
    }
    public List<Restaurant> findAll(){
        return restaurantRepository.findall();
    }
    public void updateRating(Long restaurantId){
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        if(reviews.isEmpty()) return;
        BigDecimal average = reviews.stream().map(r -> BigDecimal.valueOf(r.getRating())).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(reviews.size()),2, RoundingMode.HALF_UP);
        restaurantRepository.findall().stream().filter(r -> r.getId().equals(restaurantId)).findFirst().ifPresent(r -> {
            r.setRating(average);
            restaurantRepository.save(r);
        });
    }

    public Restaurant findById(long id) {
        return restaurantRepository.findall().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }
}