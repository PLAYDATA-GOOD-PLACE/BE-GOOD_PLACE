package com.example.food.domain.request;

import com.example.food.domain.entity.MyReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyReviewRequest {
    private String content;

    public MyReview toEntity() {
        return MyReview.builder()
                .content(content)
                .build();
    }
}
