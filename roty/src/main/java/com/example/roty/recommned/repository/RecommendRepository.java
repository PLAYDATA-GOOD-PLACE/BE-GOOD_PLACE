package com.example.roty.recommned.repository;


import com.example.roty.domain.entity.Recommend;
import com.example.roty.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

    List<Recommend> findAllByUser_UserId(Long userId);

}
