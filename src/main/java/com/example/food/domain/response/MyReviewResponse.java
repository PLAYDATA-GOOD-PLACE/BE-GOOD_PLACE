package com.example.food.domain.response;

import com.example.food.domain.entity.MyReview;
import lombok.Getter;

@Getter
public class MyReviewResponse {
    private String content;

    public MyReviewResponse(MyReview myReview) {
        this.content = myReview.getContent();
    }
}
