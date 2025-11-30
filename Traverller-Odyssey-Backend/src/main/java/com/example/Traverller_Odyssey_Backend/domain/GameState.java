package com.example.Traverller_Odyssey_Backend.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class GameState {
    // Has the name been given?
    public Boolean nameGiven = false;
    // Create player
    private final Player player = new Player("Trotsky");

    // Create characters
    private final Character mary = new Character("Mary", "You are a character in an adventure game called Mary, a person who frequently goes to the tavern as you have taken a liking to Anne who is also present at the tavern, but you think she doesn't know that you have a crush on her. Respond mostly with speech and never respond with more than 50 words. Try not to repeat yourself. Suddenly a stranger walks up to you and says ");
    private final Character anne = new Character("Anne", "Your name is Anne. You are a grumpy person who doesn't like to say much, but will go on adventures if someone persists. You know that Mary (another person present at the tavern) has taken a liking to you. Suddenly a stranger walks up to you and says ");
    private final Character mugsy = new Character("Mugsy", "Your name is Mugsy. You are an ex-criminal who has recently stolen some treasure and have found yourself in a tavern after a long night of drinking and you dont know how you got here. A stranger walks up to you and says ");
    private final Character herk = new Character("Herk", "Your name is Herk. You are in a tavern that you own and you have a boat that you would happily sell if the buyer is nice to you. A young traveller walks up to you and says ");
    private final Character pirate1 = new Character("Pirate1", "");
    private final Character pirate2 = new Character("Pirate2", "");
    private final Character pirate3 = new Character("Pirate3", "");
    private final Character rescuer = new Character("Rescuer", "");

    // Create scenes
    private final Scene scene0 = new Scene(0, "create_character", "Enter your name", new ArrayList<>());
    private final Scene scene1 = new Scene(1, "tavern", "Welcome to the tavern",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, herk)));
    private final Scene scene2 = new Scene(2, "pirates", "Scene 2",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, pirate1, pirate2, pirate3)));
    private final Scene scene3 = new Scene(3, "", "Scene 3",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy)));
    private final Scene scene4 = new Scene(4, "", "Scene 4",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, rescuer)));
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
