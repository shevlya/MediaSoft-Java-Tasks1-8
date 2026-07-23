package com.task.practice_assignment.controller;

import com.task.practice_assignment.dto.VisitorRequestDTO;
import com.task.practice_assignment.dto.VisitorResponseDTO;
import com.task.practice_assignment.service.VisitorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    @PostMapping
    public ResponseEntity<VisitorResponseDTO> createVisitor(@Valid @RequestBody VisitorRequestDTO dto){
        VisitorResponseDTO responseDTO = visitorService.createVisitor(dto);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<VisitorResponseDTO>> getAllVisitors(){
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitorResponseDTO> getVisitorById(@PathVariable Long id){
        return visitorService.getVisitorByID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitorResponseDTO> updateVisitor(@PathVariable Long id,@Valid @RequestBody VisitorRequestDTO dto){
        return visitorService.updateVisitor(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long id){
        boolean deleted = visitorService.deleteVisitor(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
