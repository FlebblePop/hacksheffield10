package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="players")
public class Player {
    // fields
    @Id
    private int id;

    private int hitPoints;

    private int pooCounter;

    @OneToMany(mappedBy = "Item")
    private List<Item> inventory;

    private String name;

    private int Strength;

    private int Knowledge;

    private int Sorcery;

    private int Investigate;

    // getters and setters
    public void setPooCounter(int pooCounter) { this.pooCounter = pooCounter; }

    public int getPooCounter() { return pooCounter; }

    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public int getHitPoints() { return hitPoints; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setStrength(int Strength) { this.Strength = Strength; }

    public int getStrength() { return Strength; }

    public void setKnowledge(int Knowledge) { this.Knowledge = Knowledge; }

    public int getKnowledge() { return Knowledge; }

    public void addItem(Item item) { this.inventory.add(item); }

    public void removeItem(Item item) { this.inventory.remove(item); }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
