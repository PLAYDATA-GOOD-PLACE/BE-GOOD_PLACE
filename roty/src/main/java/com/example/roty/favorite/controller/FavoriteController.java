package com.example.roty.favorite.controller;


import com.example.roty.domain.request.FavoriteRequest;
import com.example.roty.favorite.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("favorite")
public class FavoriteController {


    private final FavoriteService favoriteService;

    @PostMapping
    public void saveFav(@RequestBody FavoriteRequest favoriteRequest){


        favoriteService.save(favoriteRequest);
    }

    @GetMapping("{storeId}")
    public Long getCount(@PathVariable(name = "storeId") Long storeId){
        return favoriteService.getCount(storeId);
    }
}
