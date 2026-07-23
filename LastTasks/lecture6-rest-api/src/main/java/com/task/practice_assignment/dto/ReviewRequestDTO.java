package com.task.practice_assignment.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

public record ReviewRequestDTO (
    @NotNull
    Long visitorId,
    @NotNull
    Long restaurantId,
    @NotNull
    @Min(1)
    @Max(5)
    Integer rating,
    String comment
){}
