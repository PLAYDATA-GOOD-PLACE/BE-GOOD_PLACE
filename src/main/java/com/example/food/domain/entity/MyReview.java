package com.example.food.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "myReview")
public class MyReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myReviewSeq;
    @Column(columnDefinition = "TEXT")
    private String content; //리뷰  내용

    //    @ManyToOne

    public void update(String content) {
        this.content = content;
    }

}
