package com.task.practice_assignment.service;

import com.task.practice_assignment.dto.ReviewRequestDTO;
import com.task.practice_assignment.dto.ReviewResponseDTO;
import com.task.practice_assignment.mapper.ReviewMapper;
import com.task.practice_assignment.model.Review;
import com.task.practice_assignment.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final RestaurantService restaurantService;

    public ReviewResponseDTO create(ReviewRequestDTO dto) {
        Review review = reviewMapper.toEntity(dto);
        reviewRepository.save(review);
        restaurantService.updateRating(dto.restaurantId());
        return reviewMapper.toDTO(review);
    }

    public List<ReviewResponseDTO> getAll() {
        return reviewRepository.findall().stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<Review> findAll(){
        return reviewRepository.findall();
    }
}