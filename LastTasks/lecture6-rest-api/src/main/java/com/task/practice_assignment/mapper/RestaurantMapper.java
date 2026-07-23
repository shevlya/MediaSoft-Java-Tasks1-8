package com.task.practice_assignment.mapper;

import com.task.practice_assignment.dto.RestaurantRequestDTO;
import com.task.practice_assignment.dto.RestaurantResponseDTO;
import com.task.practice_assignment.model.Restaurant;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    Restaurant toEntity(RestaurantRequestDTO dto);
    RestaurantResponseDTO toDTO(Restaurant restaurant);
}
