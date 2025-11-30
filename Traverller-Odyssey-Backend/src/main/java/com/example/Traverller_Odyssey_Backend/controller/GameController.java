package com.example.Traverller_Odyssey_Backend.controller;

import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"", "/"})
@CrossOrigin
public class GameController {

    public GameController() {}

    @GetMapping({"/scene"})
    public @ResponseBody String getScene() {
        return "Welcome to the tavern";
    }

    @GetMapping("/{input}")
    public @ResponseBody String processInput(@PathVariable String input) {
        return input;
    }

    @GetMapping(value = "/image")
    public @ResponseBody String getImage() {
        return "vite";
    }
}
