package com.example.roty.recommned.service;

import com.example.roty.User.repository.UserRepository;
import com.example.roty.domain.entity.Recommend;
import com.example.roty.domain.entity.Store;
import com.example.roty.domain.entity.User;
import com.example.roty.recommned.repository.RecommendRepository;
import com.example.roty.security.oauth.PrincipalDetails;
import com.example.roty.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendRepository repository;
    private final StoreRepository storeRepository;

    public void saveSelectedPlaces(Authentication authentication, String data, String reviews) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        JSONParser parser = new JSONParser();
        try {
            JSONArray selectData = (JSONArray) parser.parse(data);

            for (Object obj : selectData) {
                JSONObject dataJson = (JSONObject) obj;

                Store store = Store.builder()
                        .placeId((String) dataJson.get("id"))
                        .name((String) dataJson.get("place_name"))
                        .address((String) dataJson.get("address_name"))
                        .phone((String) dataJson.get("phone"))
                        .foodType((String) dataJson.get("category_name"))
                        .storeImgUrl((String) dataJson.get("place_url"))
                        .coordinateX((String) dataJson.get("x"))
                        .coordinateY((String) dataJson.get("y"))
                        .myReview(reviews)
                        .build();

                if (!storeRepository.existsByPlaceId(store.getPlaceId())) {
                    User user = principal.getUser();
                    Store save = storeRepository.save(store);
                    Recommend recommend = new Recommend(null, user, save);
                    repository.save(recommend);
                } else {
                    throw new RuntimeException("STORE WITH PLACE ID ALREADY EXISTS.");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("FAILED TO PARSE DATA.");
        }
    }

}
