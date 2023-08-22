package com.example.food.domain.request;

import com.example.food.domain.entity.YourReview;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YourReviewRequest {
    private String content;

    public YourReview toEntity() {
        return YourReview.builder()
                .content(content)
                .build();
    }
}
