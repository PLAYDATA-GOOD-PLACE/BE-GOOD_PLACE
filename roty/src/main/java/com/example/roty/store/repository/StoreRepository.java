package com.example.roty.store.repository;


import com.example.roty.store.domain.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByPlaceId(String id);

    Page<Store> findAll(Pageable request);

    @Query("select s from Store s where s.address like %:keyword%")
    Page<Store> findAllByAddressContaining(Pageable request, String keyword);
}
