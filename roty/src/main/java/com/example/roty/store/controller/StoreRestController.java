package com.example.roty.store.controller;


import com.example.roty.domain.response.StoreResponse;
import com.example.roty.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class StoreRestController {
    private final StoreService storeService;

    @GetMapping
    public Page<StoreResponse> getAll(
            @RequestParam(required = false, defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false, defaultValue = "3", name = "size")
            Integer size
    ) {
        return storeService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/place/{id}")
    public StoreResponse getAllByPlaceId(@PathVariable("id") String placeId) {
        return storeService.findByPlaceId(placeId);
    }
}
