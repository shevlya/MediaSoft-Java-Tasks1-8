package com.task.practice_assignment.dto;

import com.task.practice_assignment.model.CuisineType;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.math.BigDecimal;

public record RestaurantRequestDTO (
    @NotNull
    String name,
    String description,
    @NotNull
    CuisineType cuisineType,
    @NotNull
    @Min(0)
    BigDecimal averagePrice
){}