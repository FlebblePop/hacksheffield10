package com.example.hack_sheffield_backend.domain;

import com.example.hack_sheffield_backend.dto.PlayerDTO;
import jakarta.persistence.*;

@Entity
public class Player extends Person {
    private int pooCounter;
    private int intelligence;
    private int charisma;

    public Player() {}

    public Player(String name) {
        super(name);

        this.intelligence = 10;
        this.charisma = 10;
        this.pooCounter = 0;
    }

    // getters and setters
    public void setPooCounter(int pooCounter) { this.pooCounter = pooCounter; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setCharisma(int charisma) { this.charisma = charisma; }

    public int getIntelligence() { return this.intelligence; }
    public int getCharisma() { return this.charisma; }
    public int getPooCounter() { return this.pooCounter; }

    public PlayerDTO toDto() {
        PlayerDTO dto = new PlayerDTO();
        dto.setPooCounter(this.pooCounter);
        dto.setIntelligence(this.intelligence);
        dto.setCharisma(this.charisma);
        return dto;
    }
}
