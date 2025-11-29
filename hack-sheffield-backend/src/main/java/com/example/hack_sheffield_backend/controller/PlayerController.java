package com.example.hack_sheffield_backend.controller;

import com.example.hack_sheffield_backend.domain.Player;
import com.example.hack_sheffield_backend.dto.PlayerDTO;
import com.example.hack_sheffield_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO createdPlayerDTO = playerService.createPlayer(playerDTO.toEntity()).toDto();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayerDTO);
    }
}
