package com.example.Traverller_Odyssey_Backend.controller;

import com.example.Traverller_Odyssey_Backend.domain.Player;
import com.example.Traverller_Odyssey_Backend.dto.PlayerDTO;
import com.example.Traverller_Odyssey_Backend.services.GameService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"", "/"})
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping({"", "/"})
    public @ResponseBody String getIntroText() {
        return gameService.getIntroText();
    }

    @GetMapping("/{input}")
    public @ResponseBody String processInput(@PathVariable String input) {
        return gameService.processInput(input);
    }

    @GetMapping(value = "/image")
    public @ResponseBody String getImagePath() {
        return gameService.getImagePath();
    }
}
