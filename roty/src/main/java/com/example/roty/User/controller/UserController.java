package com.example.roty.User.controller;


import com.example.roty.domain.entity.User;
import com.example.roty.User.service.UserService;
import com.example.roty.security.oauth.AuthService;
import com.example.roty.security.oauth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;
    private final UserService userService;

    @GetMapping()
    public String index() {
        return "login";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @GetMapping("/test2")
    public User test2() {
        return User.builder().userId(1L)
                .email("dafdfa@naver.com")
                .role("MEMBER").build();
    }

    //토큰발급 경로
    @GetMapping("/token")
    public String getToken(Authentication authentication) {

//        if(authentication==null){
//            return "redirect:/oauth2/authorization/kakao";
//        }

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        String token = authService.makeToken(principal.getUser());
        Long userId = principal.getUser().getUserId();

        return "redirect:http://192.168.0.172:3000/redirect?token=" + token + "&userId=" + userId;
    }


    // 시큐리티에서 꺼낸걸로 바로 받아보기
    @ResponseBody
    @GetMapping("/user")
    public User getUser(@AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (principalDetails == null) {
            return null;
        }


        return principalDetails.getUser();
    }

    //토큰으로 꺼내서 받아보기
    @ResponseBody
    @GetMapping("/tokenInfo")

    public Map<String, Object> getToken(@RequestHeader("Authorization") String token) {
        return authService.getClaims(token.replace("Bearer ", ""));

    }

}
