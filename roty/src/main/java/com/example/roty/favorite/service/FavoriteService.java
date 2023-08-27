package com.example.roty.favorite.service;

import com.example.roty.domain.entity.Favorite;
import com.example.roty.domain.request.FavoriteRequest;
import com.example.roty.domain.response.FavoriteResponse;
import com.example.roty.domain.response.StoryResponse;
import com.example.roty.favorite.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;


    public void save(FavoriteRequest favoriteRequest){

        //중복 체크
        if(favoriteRepository.findByUser_UserIdAndStore_Id(
                favoriteRequest.getUserId(), favoriteRequest.getStoreId()
        )!=null){
            return;
        }

        Favorite entity = favoriteRequest.toEntity(favoriteRequest.getUserId(), favoriteRequest.getStoreId());

        favoriteRepository.save(entity);
    }

    public Long getCount(String storeId){
       return favoriteRepository.countByStore_PlaceId(storeId);
    }

    public Object[] getAllFavList(){
        return favoriteRepository.customAllGroup();
    }


    public Optional<Favorite> find(Long id){

        return favoriteRepository.findById(id);
    }

    public void delete(Long id){
        favoriteRepository.deleteById(id);
    }

    public List<FavoriteResponse> findAllByUserId(Long userId){
        List<Favorite> all = favoriteRepository.findAllByUser_UserId(userId);
        return all.stream().map(FavoriteResponse::new).toList();
    }

}