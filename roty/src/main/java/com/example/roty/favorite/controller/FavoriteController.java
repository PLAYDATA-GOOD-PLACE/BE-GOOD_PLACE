package com.example.roty.favorite.controller;


import com.example.roty.domain.entity.Favorite;
import com.example.roty.domain.request.FavoriteRequest;
import com.example.roty.domain.response.StoryResponse;
import com.example.roty.favorite.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("favorite")
public class FavoriteController {


    private final FavoriteService favoriteService;

    @PostMapping
    public void saveFav(@RequestBody FavoriteRequest favoriteRequest){


        favoriteService.save(favoriteRequest);
    }

    @GetMapping("{placeId}")
    public Long getCount(@PathVariable(name = "placeId") String placeId){
        return favoriteService.getCount(placeId);
    }

    @GetMapping
    public Object[] getAllGroup(){
        return favoriteService.getAllFavList();
    }
}
