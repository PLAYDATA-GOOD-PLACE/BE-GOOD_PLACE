package com.example.roty.food.repository;


import com.example.roty.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findById(Long reviewSeq);

    Long countByStore_PlaceId(String placeId);
}

