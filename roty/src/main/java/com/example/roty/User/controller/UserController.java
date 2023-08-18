package com.example.roty.User.controller;


import com.example.roty.User.domain.User;
import com.example.roty.security.oauth.AuthService;
import com.example.roty.security.oauth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;
    @GetMapping
    public String index(){
        return "login";
    }

    @ResponseBody
    @GetMapping("/token")
    public String getToken(Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        String token= authService.makeToken(principal.getUser());

        return token;
    }

    @ResponseBody
    @GetMapping("/user")
    public String getUser(){

        return "유저~";
    }
}
