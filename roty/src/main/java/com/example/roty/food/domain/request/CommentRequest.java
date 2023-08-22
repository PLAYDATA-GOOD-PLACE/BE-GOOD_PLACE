package com.example.roty.food.domain.request;


import com.example.roty.food.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .build();
    }
}
