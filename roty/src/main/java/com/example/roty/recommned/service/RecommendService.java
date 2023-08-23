package com.example.roty.recommned.service;

import com.example.roty.recommned.repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendRepository repository;

}
