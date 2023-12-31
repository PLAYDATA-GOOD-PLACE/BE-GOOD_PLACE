package com.example.roty.store.repository;


import com.example.roty.domain.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByPlaceId(String id);

    Store findAllByPlaceId(String id);


    Page<Store> findAll(Pageable request);
}
