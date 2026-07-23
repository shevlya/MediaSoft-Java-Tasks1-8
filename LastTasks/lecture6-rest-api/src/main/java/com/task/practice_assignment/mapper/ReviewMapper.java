package com.task.practice_assignment.mapper;

import com.task.practice_assignment.dto.ReviewRequestDTO;
import com.task.practice_assignment.dto.ReviewResponseDTO;
import com.task.practice_assignment.model.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewRequestDTO dto);
    ReviewResponseDTO toDTO(Review review);
}
