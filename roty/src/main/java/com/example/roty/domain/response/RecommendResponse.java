package com.example.roty.domain.response;

import com.example.roty.domain.dto.StoreDto;
import com.example.roty.domain.dto.UserDto;
import com.example.roty.domain.entity.Comment;
import com.example.roty.domain.entity.Recommend;
import lombok.Getter;

@Getter
public class RecommendResponse {

    private UserDto userDto;
    private StoreDto storeDto;

    public RecommendResponse(Recommend recommend) {

        userDto = new UserDto(recommend.getUser());
        storeDto = new StoreDto(recommend.getStore());
    }
}
