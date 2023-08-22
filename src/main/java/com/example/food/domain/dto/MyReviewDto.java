package com.example.food.domain.dto;

import com.example.food.domain.entity.MyReview;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyReviewDto {
    private Long myReviewSeq;
    private String content;

    public MyReviewDto(MyReview myReview) {
        this.myReviewSeq = myReview.getMyReviewSeq();
        this.content = myReview.getContent();
    }
}
