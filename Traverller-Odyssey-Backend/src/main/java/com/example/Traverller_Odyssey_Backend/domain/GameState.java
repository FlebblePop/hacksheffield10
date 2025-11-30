package com.example.Traverller_Odyssey_Backend.domain;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.Traverller_Odyssey_Backend.domain.Character;

public final class GameState {

    // Create player
    private static final Player player = new Player("Trotsky");

    // Create characters
    private static final Character gemini = new Character("Gemini", "");
    private static final Character chatgpt = new Character("ChatGPT", "");
    private static final Character boatSeller = new Character("BoatSeller", "");
    private static final Character pirate1 = new Character("Pirate1", "");
    private static final Character pirate2 = new Character("Pirate2", "");
    private static final Character pirate3 = new Character("Pirate3", "");
    private static final Character rescuer = new Character("Rescuer", "");

    // Create scenes
    private static final Scene scene0 = new Scene(0, "", "Enter your name", new ArrayList<>());
    private static final Scene scene1 = new Scene(1, "tavern.png", "Welcome to the tavern",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, boatSeller)));
    private static final Scene scene2 = new Scene(2, "", "Scene 2",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, pirate1, pirate2, pirate3)));
    private static final Scene scene3 = new Scene(3, "", "Scene 3",
            new ArrayList<>(Arrays.asList(gemini, chatgpt)));
    private static final Scene scene4 = new Scene(4, "", "Scene 4",
            new ArrayList<>(Arrays.asList(gemini, chatgpt, rescuer)));
    private static final Scene scene5 = new Scene(5, "", "Congratulations! You survived!",
            new ArrayList<>());

    private static Scene currentScene =  scene0;

    public static Player getPlayer() {
        return player;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    public static void goToNextScene() {
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
        }
    }
}
