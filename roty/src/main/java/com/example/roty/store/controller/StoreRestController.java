package com.example.roty.store.controller;


import com.example.roty.store.domain.response.StoreResponse;
import com.example.roty.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class StoreRestController {
    private final StoreService storeService;

    @CrossOrigin("*")
    @PostMapping("/submit-selected-places")
    public ResponseEntity<String> submitSelectedPlaces(@RequestParam("selectedPlacesData") String selectedPlacesData) {
        try {
            storeService.saveSelectedPlaces(selectedPlacesData);
            return new ResponseEntity<>("Selected places submitted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to submit selected places.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public Page<StoreResponse> getAll(
            @RequestParam(required = false, defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false, defaultValue = "3", name = "size")
            Integer size
    ) {
        return storeService.findAll(PageRequest.of(page, size));
    }


    @GetMapping("/keyword")
    public Page<StoreResponse> getAllByAddressContains(
            @RequestParam(required = false, defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false, defaultValue = "3", name = "size")
            Integer size,
            @RequestParam(required = false, defaultValue = "", name = "keyword")
            String keyword
    ) {
        return storeService.findByAddressContains(PageRequest.of(page, size), keyword);
    }
}
