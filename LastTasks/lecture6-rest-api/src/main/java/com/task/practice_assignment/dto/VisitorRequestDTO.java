package com.task.practice_assignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import lombok.Value;

public record VisitorRequestDTO(
        Integer age,
        String gender,
        String name
) {}
