package com.example.roty.favorite.repository;

import com.example.roty.domain.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

    Favorite findByUser_UserIdAndStore_Id(Long userId,Long storeId);


    Long countByStore_PlaceId(String placeId);

}
