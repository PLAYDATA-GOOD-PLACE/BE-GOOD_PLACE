package com.example.roty.store.domain.response;


import com.example.roty.User.domain.dto.UserDto;
import com.example.roty.recommend.domain.entity.Recommend;
import com.example.roty.store.domain.dto.StoreDto;
import com.example.roty.store.domain.entity.Store;
import lombok.Getter;

import java.util.List;

@Getter
public class StoreResponse extends StoreDto {

    private List<UserDto> users;
    public StoreResponse(Store store) {
        super(store);
        users = store.getUsers()
                .stream().map(Recommend::getUser).map(UserDto::new)
                .toList();
    }
}
