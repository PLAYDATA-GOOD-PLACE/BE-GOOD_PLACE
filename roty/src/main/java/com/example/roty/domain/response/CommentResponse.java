package com.example.roty.domain.response;


import com.example.roty.domain.dto.CommentDto;
import com.example.roty.domain.dto.UserDto;
import com.example.roty.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse extends CommentDto {
    private UserDto user;
    private Long userId;

    public CommentResponse(Comment comment) {
        super(comment);
        user = new UserDto(comment.getUser());
        userId = comment.getUser().getUserId();
    }
}
