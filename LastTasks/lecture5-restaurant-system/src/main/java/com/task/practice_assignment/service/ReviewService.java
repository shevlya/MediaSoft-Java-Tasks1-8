package com.task.practice_assignment.service;

import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.repository.RestaurantRepository;
import com.task.practice_assignment.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public void save(Review review){
        reviewRepository.save(review);
        updateRestaurantRating(review.getRestaurantId());
    }
    public void remove(Review review){
        reviewRepository.remove(review);
        updateRestaurantRating(review.getRestaurantId());
    }
    public List<Review> findAll(){
        return reviewRepository.findall();
    }
    private void updateRestaurantRating(Long restaurantId){
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        if(reviews.isEmpty()) return;
        double average = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        restaurantRepository.findall().stream().filter(r -> r.getId().equals(restaurantId)).findFirst().ifPresent(r -> r.setRating(BigDecimal.valueOf(average)));
    }
}
