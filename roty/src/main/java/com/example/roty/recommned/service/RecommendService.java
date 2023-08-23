package com.example.roty.recommned.service;

import com.example.roty.domain.entity.Store;
import com.example.roty.recommned.repository.RecommendRepository;
import com.example.roty.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendRepository repository;
    private final StoreRepository storeRepository;


}
