package com.example.roty.favorite.repository;

import com.example.roty.domain.entity.Favorite;
import com.example.roty.domain.response.StoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

    Favorite findByUser_UserIdAndStore_Id(Long userId,Long storeId);

    List<Favorite> findAllByUser_UserId(Long userId);

    Long countByStore_PlaceId(String placeId);



    @Query(value = " SELECT user_user_id as fs,username ,COUNT(*),\n" +
            "(select count(*) from favorite where favorite.store_id in(select store_id from favorite where user_user_id =fs))\n" +
            " FROM Favorite as f\n" +
            " join user u on u.user_id = f.user_user_id\n" +
            " GROUP BY user_user_id\n" +
            " ORDER BY count(*) DESC;"
    ,nativeQuery = true)
    Object[] customAllGroup();
}
