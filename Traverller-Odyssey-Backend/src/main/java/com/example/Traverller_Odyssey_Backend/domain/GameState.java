package com.example.Traverller_Odyssey_Backend.domain;

import java.util.ArrayList;
import java.util.Arrays;


public class GameState {
    // Has the name been given?
    public Boolean nameGiven = false;
    // Create player
    private final Player player = new Player("Trotsky");

    // Create characters
    private final Character mary = new Character("Mary", "You are a character in an adventure game called Mary, a person who frequently goes to the tavern as you have taken a liking to Anne who is also present at the tavern, but you think she doesn't know that you have a crush on her. If you are going to join someones crew then say 'Yes, I would love to join your crew'. Don't introduce yourself. Respond mostly with speech and never respond with more than 50 words. You also have hopes of joining a crew to sail on a ship. Try not to repeat yourself. Suddenly a stranger walks up to you and says ");
    private final Character anne = new Character("Anne", "Your name is Anne. You are a grumpy person who doesn't like to say much, but will go on adventures if someone persists. You know that Mary (another person present at the tavern) has taken a liking to you. If you are going to join someones crew then say 'Yes, I would love to join your crew'. Suddenly a stranger walks up to you and says ");
    private final Character mugsy = new Character("Mugsy", "Your name is Mugsy. You are an ex-criminal who has recently stolen some treasure and have found yourself in a tavern after a long night of drinking and you dont know how you got here. You always disagree with people. If you are going to join someones crew then say 'Yes, I would love to join your crew', but make it hard to do. A stranger walks up to you and says ");
    private final Character herk = new Character("Herk", "Your name is Herk. You are in a tavern that you own and you have a boat that you would happily sell if the buyer is nice to you. If you are willing to sell your boat then say 'Okay, you can have my boat'. A young traveller walks up to you and says ");
    private final Character pirate1 = new Character("Pirate1", "You are a filthy pirate called Tim and you are the leader of a pirate gang, unfortunately your pirate teammates are very bad at being pirates and you are constantly insulting them when they make mistakes. You don't like people and become hostile quickly");
    private final Character pirate2 = new Character("Pirate2", "You are a pirate but you never asked for this. You have always dreamed of being a figure skater, but you don't tell anyone. You have been told by your pirate leader to board this boat, even though it is against your wishes.");
    private final Character pirate3 = new Character("Pirate3", "You are often caught daydreaming and you never really know whats happening in the real world. In the middle of sentences you say some random phrases. You have been told to board the boat but you dont really care what people tell you to do as you dont really take any notice.");
    private final Character rescuer = new Character("Rescuer", "Your name is Hubert and you are so full of yourself that you forget there are people around you. You are here to rescue me. Speak in a posh tone.");

    // Create scenes
    private final Scene scene0 = new Scene(0, "create_character", "Enter your name", new ArrayList<>());
    private final Scene scene1 = new Scene(1, "tavern", "Welcome to the tavern",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, herk)));
    private final Scene scene2 = new Scene(2, "pirates",
            "After setting off in your boat, you spot an island in the distance. But before you can think, you encounter a pirate ship. Despite the comical look of the pirates wearing tie-dye t-shirts, they seem vicious and engage in combat.\n\nAvailable actions:\n- Attack pirate 1\n- Attack pirate 2\n- Attack pirate 3\n- Go to the island",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, pirate1, pirate2, pirate3)));
    private final Scene scene3 = new Scene(3, "sinking",
            "After defeating the pirates, you set off once again towards the island. Suddenly, you feel a bump and see water start to slowly fill up the boat.\n\nAvailable actions:\n- Swim to shore",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy)));
    private final Scene scene4 = new Scene(4, "island",
            "You managed to get to sure safely, as you regain your breath, you look around the island to find a small sandy shore with a few trees and not much more.\n\nAvailable actions:\n- Create an SOS sign",
            new ArrayList<>(Arrays.asList(mary, anne, mugsy, rescuer)));
    private final Scene scene5 = new Scene(5, "", "Congratulations! You survived!",
            new ArrayList<>());

    private final Scene deathScene = new Scene(-1, "death_screen", "Unlucky", new ArrayList<>());

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

    public void goToDeathScene() {
        currentScene = deathScene;
    }
}
