package com.task.practice_assignment.repository;

import com.task.practice_assignment.model.Visitor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitorRepository {
    private final List<Visitor> visitors = new ArrayList<>();
    public void save(Visitor visitor){
        visitors.add(visitor);
    }
    public void remove(Visitor visitor){
        visitors.remove(visitor);
    }
    public List<Visitor> findAll(){
        return new ArrayList<>(visitors);
    }
    public void removeIfExist(long id){
        visitors.removeIf(v -> v.getId().equals(id));
    }
}
