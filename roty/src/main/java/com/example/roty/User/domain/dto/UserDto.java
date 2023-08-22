package com.example.roty.User.domain.dto;

import com.example.roty.User.domain.User;
import lombok.Getter;

@Getter
public class UserDto {
    private String username;
    private String email;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
