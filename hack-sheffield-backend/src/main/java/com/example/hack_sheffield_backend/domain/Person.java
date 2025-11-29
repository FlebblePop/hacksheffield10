package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Person {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "Item")
    private List<Item> inventory;

    private int money;
    private int hp;
    private int maxHp;
    private int strength;
    private int agility;

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.money = 0;
        this.maxHp = 20;
        this.hp = this.maxHp;
        this.strength = 10;
        this.agility = 10;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
