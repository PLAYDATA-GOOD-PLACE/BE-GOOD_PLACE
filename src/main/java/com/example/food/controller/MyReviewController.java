package com.example.food.controller;

import com.example.food.domain.entity.MyReview;
import com.example.food.domain.request.MyReviewRequest;
import com.example.food.domain.request.MyReviewUpdateRequest;
import com.example.food.domain.response.MyReviewResponse;
import com.example.food.service.MyReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/myReviews")
@CrossOrigin("*")
public class MyReviewController {
    private final MyReviewService reviewService;

    @GetMapping
    public List<MyReview> findAllReview() {
        return reviewService.findAllReview();
    }

    @PostMapping
    public void saveReview(@RequestBody MyReviewRequest myReviewRequest) {
        reviewService.saveReview(myReviewRequest);
    }

    @PutMapping("{myReviewSeq}")
    public MyReviewResponse updateReview(@PathVariable("myReviewSeq") Long myReviewSeq, @RequestBody MyReviewUpdateRequest myReviewUpdateRequest) {
        return reviewService.updateReview(myReviewSeq, myReviewUpdateRequest);
    }

    @DeleteMapping("{myReviewSeq}")
    public void deleteReview(@PathVariable("myReviewSeq") Long myReviewSeq) {
        reviewService.deleteReview(myReviewSeq);
    }
}
