package com.example.Traverller_Odyssey_Backend.domain;

public class Player extends Person {
    private Integer pooCounter;
    private Integer intelligence;
    private Integer charisma;

    public Player() {}

    public Player(String name) {
        super(name);

        this.intelligence = 10;
        this.charisma = 10;
        this.pooCounter = 0;
    }

    // getters and setters
    public void setPooCounter(Integer pooCounter) { this.pooCounter = pooCounter; }
    public void setIntelligence(Integer intelligence) { this.intelligence = intelligence; }
    public void setCharisma(Integer charisma) { this.charisma = charisma; }

    public Integer getIntelligence() { return this.intelligence; }
    public Integer getCharisma() { return this.charisma; }
    public Integer getPooCounter() { return this.pooCounter; }
}
