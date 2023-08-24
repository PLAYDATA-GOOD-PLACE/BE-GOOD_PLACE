package com.example.roty.favorite.repository;

import com.example.roty.domain.entity.Favorite;
import com.example.roty.domain.response.StoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    Favorite findByUser_UserIdAndStore_Id(Long userId,Long storeId);


    Long countByStore_PlaceId(String placeId);


    @Query("SELECT NEW com.example.roty.domain.response.StoryResponse(f.user.username, COUNT(*)) FROM Favorite as f GROUP BY f.user.userId ORDER BY count(*) DESC")
    List<StoryResponse> customAllGroup();
}
