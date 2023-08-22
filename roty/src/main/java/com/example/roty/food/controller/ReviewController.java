package com.example.roty.food.controller;


import com.example.roty.food.domain.entity.Review;
import com.example.roty.food.domain.request.ReviewRequest;
import com.example.roty.food.domain.request.ReviewUpdateRequest;
import com.example.roty.food.domain.response.ReviewResponse;
import com.example.roty.food.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
@CrossOrigin("*")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<Review> findAllReview() {
        return reviewService.findAllReview();
    }

    @PostMapping
    public void saveReview(@RequestBody ReviewRequest reviewRequest) {
        reviewService.saveReview(reviewRequest);
    }

    @PutMapping("{reviewSeq}")
    public ReviewResponse updateReview(@PathVariable("reviewSeq") Long reviewSeq, @RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        return reviewService.updateReview(reviewSeq, reviewUpdateRequest);
    }

    @DeleteMapping("{reviewSeq}")
    public void deleteReview(@PathVariable("reviewSeq") Long reviewSeq) {
        reviewService.deleteReview(reviewSeq);
    }
}
