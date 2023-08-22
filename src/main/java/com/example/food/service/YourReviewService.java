package com.example.food.service;


import com.example.food.domain.entity.YourReview;
import com.example.food.domain.request.YourReviewRequest;
import com.example.food.domain.request.YourReviewUpdateRequest;
import com.example.food.domain.response.YourReviewResponse;
import com.example.food.repository.YourReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class YourReviewService {
    private final YourReviewRepository yourReviewRepository;

    public List<YourReview> findAllYourReview() {
        return yourReviewRepository.findAll();
    }

    public void saveYourReview(YourReviewRequest yourReviewRequest) {
        yourReviewRepository.save(yourReviewRequest.toEntity());
    }

    public YourReviewResponse updateYourReview(Long yourReviewSeq , YourReviewUpdateRequest yourReviewUpdateRequest) {
        YourReview yourReview = findById(yourReviewSeq);
        yourReview.update(yourReviewUpdateRequest.getContent());
        return new YourReviewResponse(yourReview);
    }

    public void deleteYourReview(Long yourReviewSeq) {
        yourReviewRepository.deleteById(yourReviewSeq);
    }

    private YourReview findById(Long yourReviewSeq) {
        return yourReviewRepository.findById(yourReviewSeq).orElseThrow(()-> new RuntimeException());
    }


}
