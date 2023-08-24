package com.example.roty.domain.response;


import com.example.roty.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoryResponse {

    private String username;
    private Long count;
}