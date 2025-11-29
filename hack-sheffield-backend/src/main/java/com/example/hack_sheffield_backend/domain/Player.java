package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

import java.util.List;

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

    public int getPooCounter() { return pooCounter; }
}
