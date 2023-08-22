package com.example.food.domain.dto;

import com.example.food.domain.entity.YourReview;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class YourReviewDto {
    private Long yourReviewSeq;
    private String content;

    public YourReviewDto(YourReview yourReview) {
        this.yourReviewSeq = yourReview.getYourReviewSeq();
        this.content = yourReview.getContent();
    }
}
