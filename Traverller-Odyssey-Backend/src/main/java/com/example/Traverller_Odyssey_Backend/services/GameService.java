package com.example.Traverller_Odyssey_Backend.services;

import com.example.Traverller_Odyssey_Backend.domain.*;
import com.example.Traverller_Odyssey_Backend.domain.Character;
import com.example.Traverller_Odyssey_Backend.domain.GameState;
import com.example.Traverller_Odyssey_Backend.domain.Pronouns;
import org.springframework.stereotype.Service;

import java.util.Random;

import java.util.List;

@Service
public class GameService {

    public GameState gameState = new GameState();

    private boolean Mary = false;
    private boolean Anne = false;
    private boolean Mugsy = false;

    public String getIntroText() {
        return gameState.getCurrentScene().getIntroText();
    }

    public String processInput(String input) {

        Player player = gameState.getPlayer();

        input = input.toLowerCase();

        if (gameState.getCurrentScene().getId() == 0) {
            if (!input.isEmpty()) {
                if (!gameState.nameGiven) {
                    player.setName(input);
                    gameState.nameGiven = true;
                    return "Hello " + input + "\nNow set your pronouns! Add them and then type 'done' when finished!";
                } else {
                    if (input.equalsIgnoreCase("done")) {
                        return "[NS]Your pronouns have been set as: " + player.getPronouns().toString()
                                + "\nWelcome to the tavern";
                    } else {
                        player.addPronouns(new Pronouns(input, player));
                        System.out.println(player.getPronouns());
                        return "Added " + input + " pronouns! \ntype 'done' when finished!";
                    }

                }
            } else {
                return "Please enter your name";
            }
        } else if (input.contains("poo")) {
            player.setPooCounter(player.getPooCounter() + 1);
            if (player.getPooCounter() == 3) {
                return "SHATRICK! You have pood 3 times! Wow! You must really love pooing! Can you poo 100 times? " +
                        "If you do, there'll be a special easter egg! Im waiting. Im waiting for more poo.";
            } else if (player.getPooCounter() == 100) {
                return "Why have you pood that much. I never asked you to do that. That's too much poo.";
            } else {
                return "You have pood. Your Poo Counter has been incremented. It is now: "
                        + player.getPooCounter();
            }
        } else if (gameState.getCurrentScene().getId() == 1) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.equals("next scene")) {
                return "[NS]New Scene!";
            } else if (input.equals("death scene")) {
                return "[DS]You Died";
            } else if (input.startsWith("mary:")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mary")) {
                        String response = character.askOpenAI(input.substring(input.indexOf(":")));
                        if (response.contains("Yes, I would love to join your crew.")) {
                            Mary = true;
                            return response + "\n[Mary has joined your crew]";
                        }
                        return response;
                    }
                }
            } else if (input.startsWith("anne:")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Anne")) {
                        String response = character.askOpenAI(input.substring(input.indexOf(":")));
                        if (response.contains("Yes, I would love to join your crew.")) {
                            Anne = true;
                            return response + "\n[Anne has joined your crew]";
                        }
                        return response;
                    }
                }
            } else if (input.startsWith("herk:")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Herk")) {
                        Random r= new Random();
                        int r1 = r.nextInt(3);
                        String extra="";
                        for (int i = 0; i < r1; i++) {
                            if (characters.get(i).getName().equals("Mary")) {
                                extra = "Mary: " + characters.get(i).askOpenAI("Herk, the local tavern owner gives you an endearing smile");
                            }
                            if (characters.get(i).getName().equals("Anne")) {
                                extra = "Anne: " + characters.get(i).askOpenAI("Herk, the local tavern owner gives you an endearing smile");
                            }
                            if (characters.get(i).getName().equals("Mugsy")) {
                                extra = "Mugsy" + characters.get(i).askOpenAI("Herk, the local tavern owner gives you an endearing smile");
                            }
                        }
                        String response = character.askOpenAI(input.substring(input.indexOf(":")));
                        response = response.contains("Okay, you can have my boat") ? response + "\n[You have acquired a boat]" : response;
                        return "Herk: " + response + "\n\n" + extra;
                    }
                }
            } else if (input.startsWith("mugsy")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mugsy")) {
                        String response = character.askOpenAI(input.substring(input.indexOf(":")));
                        if (response.contains("Yes, I would love to join your crew.")) {
                            Mugsy = true;
                            return response + "\n[Mugsy has joined your crew]";
                        }
                        return response;
                    }
                }
            } else {
                return "Unrecognised action";
            }
        } else if (gameState.getCurrentScene().getId() == 2) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (Mary && (input.startsWith("mary"))) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mary")) {
                        return character.askOpenAI("You are on a boat and pirates are nearby. " + input.substring(input.indexOf(":")));
                    }
                }
            } else if (Anne && (input.startsWith("anne"))) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Anne")) {
                        return character.askOpenAI("You are now on a boat and pirates are nearby. " + input.substring(input.indexOf(":")));
                    }
                }
            } else if (Mugsy && (input.startsWith("mugsy"))) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Mugsy")) {
                        return character.askOpenAI("You are on a boat and pirates are nearby. " + input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.startsWith("pirate1")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Pirate1")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.startsWith("pirate2")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Pirate2")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else if (input.startsWith("pirate3")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Pirate3")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else {
                return handleScene2Input(input);
            }
        } else if (gameState.getCurrentScene().getId() == 3) {
            return handleScene3Input(input);
        } else if (gameState.getCurrentScene().getId() == 4) {
            if (input.isEmpty()) {
                return "Please enter an action";
            } else if (input.startsWith("rescuer")) {
                List<Character> characters = gameState.getCurrentScene().getCharacters();
                for (Character character : characters) {
                    if (character.getName().equals("Rescuer")) {
                        return character.askOpenAI(input.substring(input.indexOf(":")));
                    }
                }
            } else {
                return handleScene4Input(input);
            }
        }

        return input;
    }

    public String handleScene2Input(String input) {
        Player player = gameState.getPlayer();
        String[] input_words = input.split(" ");

        if (input_words.length == 3 && input_words[0].equals("attack") && input_words[1].equals("pirate")
                && (input_words[2].equals("1") || input_words[2].equals("2") || input_words[2].equals("3"))) {
            List<Character> characters = gameState.getCurrentScene().getCharacters();
            for (Character character : characters) {
                if (character.getName().toLowerCase().equals(input_words[1] + input_words[2])) {
                    if (character.getHp() <= 0) {
                        return character.getName() + " is already dead";
                    }

                    int playerDamage = (int)(Math.random() * 6 + 4);
                    character.setHp(character.getHp() - playerDamage);

                    int pirateDamage = 0;

                    for (Character c : gameState.getCurrentScene().getCharacters()) {
                        if (c.getName().contains("Pirate") && c.getHp() > 0) {
                            pirateDamage += (int)(Math.random() * 3);
                        }
                    }

                    player.setHp(player.getHp() - pirateDamage);
                    String pirateDamageString;

                    System.out.println(player.getHp());

                    if (player.getHp() <= 0) {
                        return "[DS]The pirates killed you.";
                    } else {
                        pirateDamageString = "\n\nThe pirates did " + pirateDamage + " damage to you.";
                    }

                    if (character.getHp() <= 0) {
                        return "You killed " + character.getName() + pirateDamageString;
                    }
                    return "You dealt " + playerDamage + " damage to " + character.getName() + pirateDamageString;
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
                    return "[NS]Changing to scene 3";
                }

                return "not all the pirates are dead";
            case "next":
                return "[NS]New Scene!";
            case "help":
                return gameState.getCurrentScene().getIntroText();
            default:
                return "Unrecognised action";
        }
    }

    public String handleScene3Input(String input) {
        if (input.equals("swim to shore")) {
            return "[NS]You made it to the shore";
        } else if (input.equals("help")) {
            return gameState.getCurrentScene().getIntroText();
        } else {
            return "Unrecognised action";
        }
    }

    public String handleScene4Input(String input) {
        Player player = gameState.getPlayer();

        if (input.equals("gather resources")) {
            player.addItemToInventory("sticks");

            return "You searched beneath the trees and found some sticks";
        } else if (input.equals("create an sos sign")) {

            if (player.getInventory().contains("sticks")) {
                return "[NS]After making a large SOS on the shore using the sticks you found, it caught the attention of a passing boat. The captan welcomed you aboard and brought you back to te mainland.";
            }

            return "You didn't manage to make an SOS sign, maybe you could find something to help you.";
        } else {
            return "Unrecognised action";
        }
    }

    public String getImagePath() {
        return gameState.getCurrentScene().getImagePath();
    }

    public void goToNextScene() {
        gameState.goToNextScene();
    }

    public void goToDeathScene() {
        gameState.goToDeathScene();
    }
}
