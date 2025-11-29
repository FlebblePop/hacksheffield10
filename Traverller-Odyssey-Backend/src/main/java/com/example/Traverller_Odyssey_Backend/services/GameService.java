package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.Player;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public String processInput(String input) {

        if (input.contains("poo")) {
            player.setPooCounter(player.getPooCounter() + 1);
            return "You have pood. Your Poo Counter has been incremented. It is now: " + player.getPooCounter();
        }
        return input;
    }
}
