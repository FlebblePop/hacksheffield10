package com.example.Traverller_Odyssey_Backend.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.Traverller_Odyssey_Backend.domain.Character;

public class GameState {
    // Has the name been given?
    public Boolean nameGiven = false;
    // Create player
    private final Player player = new Player("Trotsky");

    // Create characters
    private final Character gemini = new Character("Gemini", "");
    private final Character chatgpt = new Character("ChatGPT", "");
    private final Character boatSeller = new Character("BoatSeller", "");
    private final Character pirate1 = new Character("Pirate1", "");
    private final Character pirate2 = new Character("Pirate2", "");
    private final Character pirate3 = new Character("Pirate3", "");
    private final Character rescuer = new Character("Rescuer", "");

    // Create scenes
    private final Scene scene0 = new Scene(0, "tavern", "Enter your name", new ArrayList<>());
    private final Scene scene1 = new Scene(1, "tavern.png", "Welcome to the tavern",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, boatSeller)));
    private final Scene scene2 = new Scene(2, "", "Scene 2",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, pirate1, pirate2, pirate3)));
    private final Scene scene3 = new Scene(3, "", "Scene 3",
            new ArrayList<>(Arrays.asList(gemini, chatgpt)));
    private final Scene scene4 = new Scene(4, "", "Scene 4",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, rescuer)));
    private final Scene scene5 = new Scene(5, "", "Congratulations! You survived!",
            new ArrayList<>());

    private Scene currentScene = scene0;

    public Player getPlayer() {
        return player;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public void goToNextScene() {
        switch (currentScene.getId()) {
            case 0:
                currentScene = scene1;
                break;
            case 1:
                currentScene = scene2;
                break;
            case 2:
                currentScene = scene3;
                break;
            case 3:
                currentScene = scene4;
                break;
            case 4:
                currentScene = scene5;
                break;
        }
    }
}
