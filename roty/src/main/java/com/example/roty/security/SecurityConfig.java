package com.example.roty.security;

import com.example.roty.User.repository.UserRepository;
import com.example.roty.User.service.UserService;
//import com.example.roty.security.jwt.JwtAuthenticationFilter;
import com.example.roty.security.jwt.JwtAuthenticationFilter;
import com.example.roty.security.jwt.JwtAuthorizationFilter;
import com.example.roty.security.oauth.Oauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {

//    private final UserService userService;

    private final Oauth2UserService oauth2UserService;
    private final UserService userService;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        return http.csrf(csrf->csrf.disable())
                //시큐리티 세션 미사용 (인증,인가)
//                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //폼 로그인 비활성화
                .formLogin(f->f.disable())
                //기존 http방식 비활성화  -> Bearer 토큰
                .httpBasic(h->h.disable())
                .authorizeHttpRequests(r->{
                    r.requestMatchers("/token").permitAll();
                    r.anyRequest().permitAll();
                })
                .oauth2Login(oauth->
                oauth.userInfoEndpoint((u)->
                        u.userService(new Oauth2UserService(userRepository,authenticationManager)))
                        .loginPage("/")
                        .defaultSuccessUrl("/token")
                )
                .addFilter(new JwtAuthorizationFilter(authenticationManager))


//                .addFilter(new JwtAuthenticationFilter(authenticationManager))
//                .addFilter(new JwtAuthorizationFilter(authenticationManager))


//                .authorizeHttpRequests(r ->
//                        r.requestMatchers("/").hasRole("ROLE_USER")
//
//                )


                .build();
    }

}