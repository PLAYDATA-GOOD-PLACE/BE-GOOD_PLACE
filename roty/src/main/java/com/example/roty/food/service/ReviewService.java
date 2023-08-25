package com.example.roty.food.service;


import com.example.roty.domain.entity.Review;
import com.example.roty.domain.request.ReviewRequest;
import com.example.roty.domain.request.ReviewUpdateRequest;
import com.example.roty.domain.response.ReviewResponse;
import com.example.roty.food.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewResponse> findAllReview(String id) {
        List<Review> all = reviewRepository.findFetchAllByStoreId(id);
        return all.stream().map(ReviewResponse::new).toList();
    }

    public void saveReview(ReviewRequest reviewRequest, Long userId, Long id) {
        reviewRepository.save(reviewRequest.toEntity(userId, id));
    }

    public ReviewResponse updateReview(Long reviewSeq, ReviewUpdateRequest reviewUpdateRequest) {
        Review review = findById(reviewSeq);
        review.update(reviewUpdateRequest.getContent());
        return new ReviewResponse(review);
    }

    public void deleteReview(Long reviewSeq) {
        reviewRepository.deleteById(reviewSeq);
    }

    private Review findById(Long reviewSeq) {
        return reviewRepository.findByReviewSeq(reviewSeq).orElseThrow(() -> new RuntimeException());
    }


    public Long getCount(String placeId) {

        return reviewRepository.countByStore_PlaceId(placeId);
    }
}
