package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String getIntroText() {
        return GameState.getCurrentScene().getIntroText();
    }

    public String processInput(String input) {

        if (input.contains("poo")) {
            GameState.getPlayer().setPooCounter(GameState.getPlayer().getPooCounter() + 1);
            return "You have pood. Your Poo Counter has been incremented. It is now: "
                    + GameState.getPlayer().getPooCounter();
        }

        return input;
    }

    public String getImagePath() {
        return GameState.getCurrentScene().getImagePath();
    }
}
