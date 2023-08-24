package com.example.roty.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    private String email;

   //권한
    private String role;

    private String provider;

    private String providerId;

    private String profilePath;

    @OneToMany
    private List<Recommend> recommends = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    List<Review> reviews = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    List<Comment> comments = new ArrayList<>();

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<>();
        collet.add(new SimpleGrantedAuthority("ROLE_"+role));
        return collet;
    }

}
