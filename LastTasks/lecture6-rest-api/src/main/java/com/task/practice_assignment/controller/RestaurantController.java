package com.task.practice_assignment.controller;


import com.task.practice_assignment.dto.RestaurantRequestDTO;
import com.task.practice_assignment.dto.RestaurantResponseDTO;
import com.task.practice_assignment.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public RestaurantResponseDTO create(@Valid @RequestBody RestaurantRequestDTO dto) {
        return restaurantService.create(dto);
    }

    @GetMapping
    public List<RestaurantResponseDTO> getAll() {
        return restaurantService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantService.remove(id);
    }
}

