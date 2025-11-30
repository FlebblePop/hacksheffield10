package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.Character;
import com.example.Traverller_Odyssey_Backend.domain.GameState;
import com.example.Traverller_Odyssey_Backend.domain.Pronouns;
import com.example.Traverller_Odyssey_Backend.domain.Character;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    public GameState gameState = new GameState();

    public String getIntroText() {
        return gameState.getCurrentScene().getIntroText();
    }

    public String processInput(String input) {

        if (gameState.getCurrentScene().getId() == 0) {
            if (!input.isEmpty()) {
                if (!gameState.nameGiven) {
                    gameState.getPlayer().setName(input);
                    gameState.nameGiven = true;
                    return "Hello " + input + "\nNow set your pronouns! Add them and then type 'done' when finished!";
                } else {
                    if (input.equalsIgnoreCase("done")) {
                        gameState.goToNextScene();
                        return "Your pronouns have been set as: " + gameState.getPlayer().getPronouns().toString()
                                + "\nWelcome to the tavern";
                    } else {
                        gameState.getPlayer().addPronouns(new Pronouns(input, gameState.getPlayer()));
                        System.out.println(gameState.getPlayer().getPronouns());
                        return "Added " + input + " pronouns! \ntype 'done' when finished!";
                    }

                }
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
            String[] input_words = input.split(" ");

            if (input_words.length == 3 && input_words[0].equals("attack") && input_words[1].equals("pirate")
                    && (input_words[2].equals("1") || input_words[2].equals("2") || input_words[2].equals("3"))) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().toLowerCase().equals(input_words[1] + input_words[2])) {
                        if (character.getHp() <= 0) {
                            return character.getName() + " is already dead";
                        }

                        int damage = (int)(Math.random() * 6 + 4);
                        character.setHp(character.getHp() - damage);

                        if (character.getHp() <= 0) {
                            return "You killed " + character.getName();
                        }
                        return "You dealt " + damage + " damage to " + character.getName();
                    }
                }
            }

            switch (input) {
                case "go to the island":
                    boolean killedAllPirates = true;

                    for (Character character : gameState.getCurrentScene().getCharacters()) {
                        if (character.getName().contains("Pirate") && character.getHp() > 0) {
                            killedAllPirates = false;
                        }
                    }

                    if (killedAllPirates) {
                        gameState.goToNextScene();
                        return "changing to scene 3";
                    }

                    return "not all the pirates are dead";
                case "help":
                    return gameState.getCurrentScene().getIntroText();
                default:
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
