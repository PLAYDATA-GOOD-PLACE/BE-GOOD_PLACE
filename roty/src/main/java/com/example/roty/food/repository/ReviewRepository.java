package com.example.roty.food.repository;


import com.example.roty.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r from Review as r " +
            "join r.user as u on r.user.userId = u.userId  WHERE r.store.placeId =:id")
    List<Review> findFetchAllByStoreId(@Param("id") String id );
    Optional<Review> findByReviewSeq(Long reviewSeq);
}

