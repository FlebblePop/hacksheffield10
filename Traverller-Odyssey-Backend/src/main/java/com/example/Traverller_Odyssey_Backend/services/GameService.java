package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.Character;
import com.example.Traverller_Odyssey_Backend.domain.GameState;
import org.springframework.stereotype.Service;

import java.util.List;

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

                return "Hello " + input;
            } else {
                return "Please enter your name";
            }
        } else if (input.contains("poo")) {
            gameState.getPlayer().setPooCounter(gameState.getPlayer().getPooCounter() + 1);
            return "You have pood. Your Poo Counter has been incremented. It is now: "
                    + gameState.getPlayer().getPooCounter();
        } else if (gameState.getCurrentScene().getId() == 1) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.contains("mary")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mary")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.contains("anne")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Anne")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.contains("herk")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Herk")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.contains("mugsy")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mugsy")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
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
