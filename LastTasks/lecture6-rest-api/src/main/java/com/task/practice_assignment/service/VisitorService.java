package com.task.practice_assignment.service;

import com.task.practice_assignment.dto.VisitorRequestDTO;
import com.task.practice_assignment.dto.VisitorResponseDTO;
import com.task.practice_assignment.mapper.VisitorMapper;
import com.task.practice_assignment.model.Visitor;
import com.task.practice_assignment.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;
    private final VisitorMapper visitorMapper;

    public VisitorResponseDTO createVisitor(VisitorRequestDTO dto){
        Visitor visitor = visitorMapper.toEntity(dto);
        visitor.setId(System.currentTimeMillis());
        visitorRepository.save(visitor);
        return visitorMapper.toDTO(visitor);
    }

    public List<VisitorResponseDTO> getAllVisitors(){
        return visitorRepository.findAll().stream().map(visitorMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<VisitorResponseDTO> getVisitorByID(Long id){
        return visitorRepository.findAll().stream().filter(v -> v.getId().equals(id)).findFirst().map(visitorMapper::toDTO);
    }

    public boolean deleteVisitor(Long id){
        Optional<Visitor> visitor = visitorRepository.findAll().stream().filter(v -> v.getId().equals(id)).findFirst();
        visitor.ifPresent(visitorRepository::remove);
        return visitor.isPresent();
    }

    public Optional<VisitorResponseDTO> updateVisitor(Long id, VisitorRequestDTO dto){
        Optional<Visitor> existingVisitor = visitorRepository.findAll().stream().filter(v -> v.getId().equals(id)).findFirst();

        if(existingVisitor.isPresent()){
            Visitor updatedVisitor = visitorMapper.toEntity(dto);
            updatedVisitor.setId(id);
            visitorRepository.remove(existingVisitor.get());
            visitorRepository.save(updatedVisitor);
            return Optional.of(visitorMapper.toDTO(updatedVisitor));
        }
        return Optional.empty();
    }
    public List<Visitor> findAll(){
        return visitorRepository.findAll();
    }
}
