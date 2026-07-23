package com.task.practice_assignment.service;

import com.task.practice_assignment.dto.RestaurantRequestDTO;
import com.task.practice_assignment.dto.RestaurantResponseDTO;
import com.task.practice_assignment.mapper.RestaurantMapper;
import com.task.practice_assignment.model.Restaurant;
import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.repository.RestaurantRepository;
import com.task.practice_assignment.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final ReviewRepository reviewRepository;

    public RestaurantResponseDTO create(RestaurantRequestDTO dto) {
        Restaurant restaurant = restaurantMapper.toEntity(dto);
        restaurant.setId(System.currentTimeMillis());
        restaurantRepository.save(restaurant);
        return restaurantMapper.toDTO(restaurant);
    }

    public List<RestaurantResponseDTO> getAll() {
        return restaurantRepository.findall().stream().map(restaurantMapper::toDTO).collect(Collectors.toList());
    }

    public void remove(Long id) {
        restaurantRepository.findall().stream().filter(r -> r.getId().equals(id)).findFirst().ifPresent(restaurantRepository::remove);
    }

    public void updateRating(Long restaurantId) {
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        if (reviews.isEmpty()) return;
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        restaurantRepository.findall().stream().filter(r -> r.getId().equals(restaurantId)).findFirst().ifPresent(r -> r.setRating(BigDecimal.valueOf(avg)));
    }
    public List<Restaurant> findAll(){
        return restaurantRepository.findall();
    }

    public Restaurant findById(long id) {
        return restaurantRepository.findall().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public Restaurant createManual(RestaurantRequestDTO dto, Long id) {
        Restaurant restaurant = restaurantMapper.toEntity(dto);
        restaurant.setId(id);
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}