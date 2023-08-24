package com.example.roty.favorite.controller;


import com.example.roty.domain.request.FavoriteRequest;
import com.example.roty.favorite.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FavoriteController {


    private final FavoriteService favoriteService;

    @PostMapping("favorite")
    public void saveFav(@RequestBody FavoriteRequest favoriteRequest){


        favoriteService.save(favoriteRequest);
    }
}
