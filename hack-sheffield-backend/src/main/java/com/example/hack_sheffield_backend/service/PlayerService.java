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

    public Player updatePlayer(Player player) {
        Player currentPlayer = playerRepository.findById(PLAYER_ID).orElse(null);
        if (currentPlayer != null) {
            if (player.getName() != null) {
                currentPlayer.setName(player.getName());
            }
            if (player.getCharisma() != null) {
                currentPlayer.setCharisma(player.getCharisma());
            }
            if (player.getPooCounter() != null) {
                currentPlayer.setCharisma(player.getCharisma());
            }
            if (player.getMaxHp() != null) {
                currentPlayer.setMaxHp(player.getMaxHp());
            }
            if (player.getCharisma() != null) {
                currentPlayer.setCharisma(player.getCharisma());
            }
            if (player.getHp() != null) {
                currentPlayer.setHp(player.getHp());
            }
            if (player.getAgility() != null) {
                currentPlayer.setAgility(player.getAgility());
            }
            if (player.getInventory() != null) {
                currentPlayer.setInventory(player.getInventory());
            }
            if (player.getPronouns() != null) {
                currentPlayer.setPronouns(player.getPronouns());
            }
            playerRepository.save(currentPlayer);
        }
        return currentPlayer;
    }

    public List<Item> getInventory() {
        return playerRepository.findById(PLAYER_ID).orElseThrow().getInventory();
    }
}
