package com.example.roty.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.roty.domain.entity.Comment;

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
