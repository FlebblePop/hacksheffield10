package com.example.Traverller_Odyssey_Backend.domain;

public class Player extends Person {
    private Integer pooCounter;

    public Player() {}

    public Player(String name) {
        super(name);

        this.pooCounter = 0;
    }

    // getters and setters
    public void setPooCounter(Integer pooCounter) { this.pooCounter = pooCounter; }

    public Integer getPooCounter() { return this.pooCounter; }
}
