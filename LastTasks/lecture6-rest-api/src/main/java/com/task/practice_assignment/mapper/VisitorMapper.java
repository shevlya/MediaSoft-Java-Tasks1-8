package com.task.practice_assignment.mapper;

import com.task.practice_assignment.dto.VisitorRequestDTO;
import com.task.practice_assignment.dto.VisitorResponseDTO;
import com.task.practice_assignment.model.Visitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper {
    Visitor toEntity(VisitorRequestDTO dto);
    VisitorResponseDTO toDTO(Visitor visitor);
}
