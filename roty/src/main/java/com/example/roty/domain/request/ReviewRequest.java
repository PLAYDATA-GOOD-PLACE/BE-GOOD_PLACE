package com.example.roty.domain.request;


import com.example.roty.domain.entity.Review;
import com.example.roty.domain.entity.Store;
import com.example.roty.domain.entity.User;
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

    public Review toEntity(Long userId, Long id) {
        return Review.builder()
                .content(content)
                .user(User.builder().userId(userId).build())
                .store(Store.builder().id(id).build())
                .build();
    }
}
