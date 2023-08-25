package com.example.roty.recommned.repository;


import com.example.roty.domain.entity.Recommend;
import com.example.roty.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    @Query("SELECT r.store FROM Recommend r WHERE r.user.userId = :userId")
    List<Store> findStoresByUserId(@Param("userId") Long userId);
}
