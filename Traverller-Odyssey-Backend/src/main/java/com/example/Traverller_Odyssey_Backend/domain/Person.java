package com.example.Traverller_Odyssey_Backend.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private int id;
    private String name;

    private List<String> inventory;

    private Integer hp;
    private Integer maxHp;

    private List <Pronouns> pronouns;

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.maxHp = 20;
        this.hp = this.maxHp;
        this.pronouns = new ArrayList<>();
    }

    public void addPronouns(Pronouns pronouns) {
        this.pronouns.add(pronouns);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setPronouns(List<Pronouns> pronouns) {
        this.pronouns = pronouns;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() { return name; }

    public List<String> getInventory() { return inventory; }

    public Integer getHp() { return hp; }

    public List<Pronouns> getPronouns() { return pronouns.stream().toList(); }

    public Integer getMaxHp() { return maxHp; }

    public void addItemToInventory(String item) {
        this.inventory.add(item);
    }
}
