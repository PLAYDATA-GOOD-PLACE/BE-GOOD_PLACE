package com.example.roty.store.service;

import com.example.roty.domain.entity.Store;
import com.example.roty.domain.response.StoreResponse;
import com.example.roty.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public Page<StoreResponse> findAll(PageRequest request) {
        Page<Store> all = storeRepository.findAll(request);
        return all.map(StoreResponse::new);
    }


    public StoreResponse findByPlaceId(String placeId) {
        Store store = storeRepository.findAllByPlaceId(placeId);
        return new StoreResponse(store);
    }

}
