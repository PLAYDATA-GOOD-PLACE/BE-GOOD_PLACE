package com.example.roty.store.repository;


import com.example.roty.domain.entity.Store;
import com.example.roty.domain.response.StoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByPlaceId(String id);

    Store findAllByPlaceId(String id);


    Page<Store> findAll(Pageable request);

    @Query("select s from Store s where s.address like %:keyword%")
    Page<Store> findAllByAddressContaining(Pageable request, String keyword);


}
