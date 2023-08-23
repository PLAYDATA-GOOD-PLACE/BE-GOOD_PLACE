package com.example.roty.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewSeq;
    @Column(columnDefinition = "TEXT")
    private String content; //리뷰  내용

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    

    public void update(String content) {
        this.content = content;
    }

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @ManyToOne
    private Store store;
}
