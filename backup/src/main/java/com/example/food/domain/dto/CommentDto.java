package com.example.food.domain.dto;

import com.example.food.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
    private Long commentSeq;
    private String content;

    public CommentDto(Comment comment) {
        this.commentSeq = comment.getCommentSeq();
        this.content = comment.getContent();
    }
}
