package com.example.roty.domain.response;


import com.example.roty.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
    private String content;

    public CommentResponse(Comment comment) {
        this.content = comment.getContent();
    }
}
