package com.example.roty.recommned.repository;


import com.example.roty.domain.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

}
