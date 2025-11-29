package com.example.hack_sheffield_backend.dto;

import com.example.hack_sheffield_backend.domain.Player;

public class PlayerDTO extends PersonDTO {
    public PlayerDTO() {}

    private int pooCounter;
    private int intelligence;
    private int charisma;

    public void setPooCounter(int pooCounter) { this.pooCounter = pooCounter; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setCharisma(int charisma) { this.charisma = charisma; }

    public int getIntelligence() { return this.intelligence; }
    public int getCharisma() { return this.charisma; }
    public int getPooCounter() { return this.pooCounter; }

    public Player toEntity() {
        Player player = new Player();
        player.setIntelligence(this.intelligence);
        player.setCharisma(this.charisma);
        player.setPooCounter(this.pooCounter);
        return player;
    }
}
