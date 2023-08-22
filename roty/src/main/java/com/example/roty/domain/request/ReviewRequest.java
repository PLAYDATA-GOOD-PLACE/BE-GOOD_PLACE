package com.example.roty.domain.request;


import com.example.roty.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String content;

    public Review toEntity() {
        return Review.builder()
                .content(content)
                .build();
    }
}
