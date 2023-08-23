package com.example.roty.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentSeq;
    @Column(columnDefinition = "TEXT")
    private String content; //댓글 내용

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    private Review review;

    public void update(String content) {
        this.content = content;
    }
}
