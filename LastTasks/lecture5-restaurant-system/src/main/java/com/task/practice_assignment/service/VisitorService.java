package com.task.practice_assignment.service;

import com.task.practice_assignment.model.Visitor;
import com.task.practice_assignment.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public void save(Visitor visitor){
        visitorRepository.save(visitor);
    }
    public void remove(Visitor visitor){
        visitorRepository.remove(visitor);
    }
    public List<Visitor> findAll(){
        return visitorRepository.findall();
    }
}
