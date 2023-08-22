package com.example.roty.recommend.domain.entity;

import com.example.roty.User.domain.User;
import com.example.roty.store.domain.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recommend")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Recommend {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Store store;
}
