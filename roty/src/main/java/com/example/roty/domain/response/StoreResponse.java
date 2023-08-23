package com.example.roty.domain.response;


import com.example.roty.domain.dto.StoreDto;
import com.example.roty.domain.dto.UserDto;
import com.example.roty.domain.entity.Favorite;
import com.example.roty.domain.entity.Store;
import com.example.roty.domain.entity.Recommend;
import lombok.Getter;

import java.util.List;

@Getter
public class StoreResponse extends StoreDto {
    private List<UserDto> users;
    private List<UserDto> favorites;

    public StoreResponse(Store store) {
        super(store);
        users = store.getUsers().stream().map(Recommend::getUser).map(UserDto::new).toList();
        favorites = store.getFavorites().stream().map(Favorite::getUser).map(UserDto::new).toList();
    }
}
