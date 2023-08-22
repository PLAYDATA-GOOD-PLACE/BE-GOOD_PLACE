package com.example.food.repository;

import com.example.food.domain.entity.MyReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyReviewRepository extends JpaRepository<MyReview, Long> {
    Optional<MyReview> findById(Long myReviewSeq);
}

