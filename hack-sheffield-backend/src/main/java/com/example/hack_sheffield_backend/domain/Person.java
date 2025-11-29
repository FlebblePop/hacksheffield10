package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public abstract class Person {
    @Id
    private int id;
    private String name;
    private List<Item> inventory;
    private int money;
    private int hp;
    private int maxHp;
    private int strength;
    private int agility;
    private int intelligence;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
