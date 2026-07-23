package com.task.practice_assignment.controller;

import com.task.practice_assignment.dto.ReviewRequestDTO;
import com.task.practice_assignment.dto.ReviewResponseDTO;
import com.task.practice_assignment.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponseDTO create(@Valid @RequestBody ReviewRequestDTO dto) {
        return reviewService.create(dto);
    }

    @GetMapping
    public List<ReviewResponseDTO> getAll() {
        return reviewService.getAll();
    }
}
