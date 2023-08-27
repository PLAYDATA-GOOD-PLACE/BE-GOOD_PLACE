package com.example.roty.domain.response;

import com.example.roty.domain.dto.StoreDto;
import com.example.roty.domain.dto.UserDto;
import com.example.roty.domain.entity.Favorite;
import lombok.Getter;

import java.util.List;

@Getter
public class FavoriteResponse {
    private StoreDto stores;
    private UserDto users;

    public FavoriteResponse(Favorite favorite) {
        this.stores = new StoreDto(favorite.getStore());
        this.users = new UserDto(favorite.getUser());
    }
}
