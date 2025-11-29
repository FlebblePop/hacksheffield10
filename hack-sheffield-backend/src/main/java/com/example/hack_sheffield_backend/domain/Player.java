package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    private int id;
    private int hitPoints;
    private int pooCounter;

    private void setPooCounter (int pooCounter) { this.pooCounter = pooCounter; }

    private int getPooCounter() { return pooCounter; }

    private void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    private int getHitPoints() { return hitPoints; }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
