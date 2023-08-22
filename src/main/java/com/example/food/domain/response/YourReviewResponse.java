package com.example.food.domain.response;

import com.example.food.domain.entity.YourReview;
import lombok.Getter;

@Getter
public class YourReviewResponse {
    private String content;

    public YourReviewResponse(YourReview yourReview) {
        this.content = yourReview.getContent();
    }
}
