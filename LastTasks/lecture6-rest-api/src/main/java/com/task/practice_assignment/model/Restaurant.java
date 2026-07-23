package com.task.practice_assignment.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Long id;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private CuisineType cuisineType;
    @NonNull
    private BigDecimal averagePrice;
    private BigDecimal rating = BigDecimal.ZERO;
}
