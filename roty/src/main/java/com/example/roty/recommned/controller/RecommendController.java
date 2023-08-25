package com.example.roty.recommned.controller;

import com.example.roty.domain.entity.Store;
import com.example.roty.recommned.service.RecommendService;
import com.example.roty.security.oauth.PrincipalDetails;
import com.example.roty.store.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recommend")
public class RecommendController {

    private final RecommendService recommendService;
    private final FirebaseService firebaseService;

    @CrossOrigin("*")
    @PostMapping("/submit-selected-places")
    public ResponseEntity<String> submitSelectedPlaces(Authentication authentication,
                                                       @RequestParam("selectedPlacesData") String selectedPlacesData,
                                                       @RequestParam("reviews") String reviews,
                                                       @RequestParam("files") List<MultipartFile> multipartFiles,
                                                       @RequestParam("nameFiles") List<String> nameFiles,
                                                       @RequestParam("placeId") String placeId) {
        try {
            recommendService.saveSelectedPlaces(authentication, selectedPlacesData, reviews);
            firebaseService.uploadFiles(multipartFiles, nameFiles, placeId);
            // You can use the mediaLinks for any further processing if needed
            return new ResponseEntity<>("Selected places submitted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to submit selected places.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
