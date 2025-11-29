package com.example.hack_sheffield_backend.service;

import com.example.hack_sheffield_backend.domain.Item;
import com.example.hack_sheffield_backend.domain.Player;
import com.example.hack_sheffield_backend.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final int PLAYER_ID = 1;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Item> getInventory() {
        return playerRepository.findById(PLAYER_ID).orElseThrow().getInventory();
    }
}
