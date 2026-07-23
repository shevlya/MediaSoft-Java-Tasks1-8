package com.task.practice_assignment.repository;

import com.task.practice_assignment.model.Review;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepository {
    private final List<Review> reviews = new ArrayList<>();
    public void save(Review review){
        reviews.add(review);
    }
    public void remove(Review review){
        reviews.remove(review);
    }
    public List<Review> findall(){
        return new ArrayList<>(reviews);
    }
    public List<Review> findByRestaurantId(Long restaurantId){
        return reviews.stream().filter(r -> r.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());
    }
}
