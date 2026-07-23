package com.task.practice_assignment.dto;

public record ReviewResponseDTO(
        Long visitorId,
        Long restaurantId,
        Integer rating,
        String comment
) {}
