package com.task.practice_assignment.dto;

import com.task.practice_assignment.model.CuisineType;
import java.math.BigDecimal;

public record RestaurantResponseDTO(
        Long id,
        String name,
        String description,
        CuisineType cuisineType,
        BigDecimal averagePrice,
        BigDecimal rating
) {}