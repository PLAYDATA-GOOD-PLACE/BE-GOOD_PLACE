package com.example.food.service;

import com.example.food.domain.entity.MyReview;
import com.example.food.domain.request.MyReviewRequest;
import com.example.food.domain.request.MyReviewUpdateRequest;
import com.example.food.domain.response.MyReviewResponse;
import com.example.food.repository.MyReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MyReviewService {
    private final MyReviewRepository myReviewRepository;

    public List<MyReview> findAllReview() {
        return myReviewRepository.findAll();
    }

    public void saveReview(MyReviewRequest myReviewRequest) {
        myReviewRepository.save(myReviewRequest.toEntity());
    }

    public MyReviewResponse updateReview(Long myReviewSeq , MyReviewUpdateRequest myReviewUpdateRequest) {
        MyReview myReview = findById(myReviewSeq);
        myReview.update(myReviewUpdateRequest.getContent());
        return new MyReviewResponse(myReview);
    }

    public void deleteReview(Long myReviewSeq) {
        myReviewRepository.deleteById(myReviewSeq);
    }

    private MyReview findById(Long myReviewSeq) {
        return myReviewRepository.findById(myReviewSeq).orElseThrow(()-> new RuntimeException());
    }


}
