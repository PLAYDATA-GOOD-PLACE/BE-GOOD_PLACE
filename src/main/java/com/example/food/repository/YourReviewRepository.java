package com.example.food.repository;

import com.example.food.domain.entity.YourReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YourReviewRepository extends JpaRepository<YourReview, Long> {
    Optional<YourReview> findById(Long yourReviewSeq);
}

