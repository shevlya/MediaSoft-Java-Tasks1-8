package com.task.practice_assignment.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private Long id;
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String gender;
}
