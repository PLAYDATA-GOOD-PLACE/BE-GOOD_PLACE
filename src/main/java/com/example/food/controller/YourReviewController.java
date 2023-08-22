package com.example.food.controller;

import com.example.food.domain.entity.YourReview;
import com.example.food.domain.request.YourReviewRequest;
import com.example.food.domain.request.YourReviewUpdateRequest;
import com.example.food.domain.response.YourReviewResponse;
import com.example.food.service.YourReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/yourReviews")
@CrossOrigin("*")
public class YourReviewController {
    private final YourReviewService yourReviewService;

    @GetMapping
    public List<YourReview> findAllYourReview() {
        return yourReviewService.findAllYourReview();
    }

    @PostMapping
    public void saveYourReview(@RequestBody YourReviewRequest yourReviewRequest) {
        yourReviewService.saveYourReview(yourReviewRequest);
    }

    @PutMapping("{yourReviewSeq}")
    public YourReviewResponse updateYourReview(@PathVariable("yourReviewSeq") Long yourReviewSeq, @RequestBody YourReviewUpdateRequest yourReviewUpdateRequest) {
        return yourReviewService.updateYourReview(yourReviewSeq, yourReviewUpdateRequest);
    }

    @DeleteMapping("{yourReviewSeq}")
    public void deleteYourReview(@PathVariable("yourReviewSeq") Long yourReviewSeq) {
        yourReviewService.deleteYourReview(yourReviewSeq);
    }
}
