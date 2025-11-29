package com.example.hack_sheffield_backend.controller;

import com.example.hack_sheffield_backend.service.SceneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenes")
public class SceneController {

    private SceneService sceneService;

    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }
}
