package com.example.roty.recommned.controller;

import com.example.roty.recommned.service.RecommendService;
import com.example.roty.security.oauth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    private final RecommendService recommendService;

    @CrossOrigin("*")
    @PostMapping("/submit-selected-places")
    public ResponseEntity<String> submitSelectedPlaces(Authentication authentication,
                                                       @RequestParam("selectedPlacesData") String selectedPlacesData,
                                                       @RequestParam("reviews") String reviews) {
        try {
            recommendService.saveSelectedPlaces(authentication, selectedPlacesData, reviews);
            return new ResponseEntity<>("Selected places submitted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to submit selected places.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
