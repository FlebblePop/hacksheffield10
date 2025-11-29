package com.example.Traverller_Odyssey_Backend.controller;

import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"", "/"})
public class GameController {

    public GameController() {}

    @GetMapping({"", "/"})
    public ResponseEntity<> getScene() {}

    @GetMapping("/{input}")
    public ResponseEntity<> processInput(@PathVariable String input) {}

    @GetMapping(value = "/image")
    public @ResponseBody String getImage() {
        return "tavern.png";
    }
}
