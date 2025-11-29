package com.example.hack_sheffield_backend.service;

import com.example.hack_sheffield_backend.repository.SceneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SceneService{

    private final SceneRepository sceneRepository;

    public SceneService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }
}
