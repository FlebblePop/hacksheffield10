package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String getIntroText() {
        return GameState.getCurrentScene().getIntroText();
    }

    public String processInput(String input) {

        if (GameState.getCurrentScene().getId() == 0) {
            if (!input.isEmpty()) {
                GameState.getPlayer().setName(input);
                GameState.goToNextScene();
                System.out.println(GameState.getCurrentScene().getId());

                return "Hello " + input;
            } else {
                return "Please enter your name";
            }
        } else if (input.contains("poo")) {
            GameState.getPlayer().setPooCounter(GameState.getPlayer().getPooCounter() + 1);
            return "You have pood. Your Poo Counter has been incremented. It is now: "
                    + GameState.getPlayer().getPooCounter();
        } else if (GameState.getCurrentScene().getId() == 1) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                GameState.goToNextScene();

                return "changing to scene 2";
            } else {
                return "Unrecognised action";
            }
        } else if (GameState.getCurrentScene().getId() == 2) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                GameState.goToNextScene();

                return "changing to scene 3";
            } else {
                return "Unrecognised action";
            }
        } else if (GameState.getCurrentScene().getId() == 3) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                GameState.goToNextScene();

                return "changing to scene 4";
            } else {
                return "Unrecognised action";
            }
        } else if (GameState.getCurrentScene().getId() == 4) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                GameState.goToNextScene();

                return "changing to scene 5";
            } else {
                return "Unrecognised action";
            }
        }

        return input;
    }

    public String getImagePath() {
        return GameState.getCurrentScene().getImagePath();
    }
}
