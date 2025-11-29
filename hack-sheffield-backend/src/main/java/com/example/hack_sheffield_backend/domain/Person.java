package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Item> inventory;

    private int money;
    private int hp;
    private int maxHp;
    private int strength;
    private int agility;

    @OneToMany(mappedBy = "id")
    private List <Pronouns> pronouns;

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

    public List<Item> getInventory() {
        return inventory;
    }
}
