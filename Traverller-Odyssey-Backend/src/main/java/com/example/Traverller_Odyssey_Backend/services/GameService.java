package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameState gameState = new GameState();

    public String getIntroText() {
        return gameState.getCurrentScene().getIntroText();
    }

    public String processInput(String input) {

        if (gameState.getCurrentScene().getId() == 0) {
            if (!input.isEmpty()) {
                gameState.getPlayer().setName(input);
                gameState.goToNextScene();
                System.out.println(gameState.getCurrentScene().getId());

                return "Hello " + input;
            } else {
                return "Please enter your name";
            }
        } else if (input.contains("poo")) {
            gameState.getPlayer().setPooCounter(gameState.getPlayer().getPooCounter() + 1);
            if (gameState.getPlayer().getPooCounter() == 3) {
                return "SHATRICK! You have pood 3 times! Wow! You must really love pooing! Can you poo 100 times? " +
                        "If you do, there'll be a special easter egg! Im waiting. Im waiting for more poo.";
            } else if (gameState.getPlayer().getPooCounter() == 100) {
                return "Why have you pood that much. I never asked you to do that. That's too much poo.";
            }
            return "You have pood. Your Poo Counter has been incremented. It is now: "
                    + gameState.getPlayer().getPooCounter();
        } else if (gameState.getCurrentScene().getId() == 1) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                gameState.goToNextScene();

                return "changing to scene 2";
            } else {
                return "Unrecognised action";
            }
        } else if (gameState.getCurrentScene().getId() == 2) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                gameState.goToNextScene();

                return "changing to scene 3";
            } else {
                return "Unrecognised action";
            }
        } else if (gameState.getCurrentScene().getId() == 3) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                gameState.goToNextScene();

                return "changing to scene 4";
            } else {
                return "Unrecognised action";
            }
        } else if (gameState.getCurrentScene().getId() == 4) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                gameState.goToNextScene();

                return "changing to scene 5";
            } else {
                return "Unrecognised action";
            }
        }

        return input;
    }

    public String getImagePath() {
        return gameState.getCurrentScene().getImagePath();
    }
}
