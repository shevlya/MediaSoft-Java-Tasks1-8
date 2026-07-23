package com.task.practice_assignment.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @NonNull
    private Long visitorId;
    @NonNull
    private Long restaurantId;
    @NonNull
    private Integer rating;
    private String comment;
}
