package com.example.hack_sheffield_backend.domain;

import com.example.hack_sheffield_backend.dto.PersonDTO;
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
        this.pronouns = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setPronouns(List<Pronouns> pronouns) {
        this.pronouns = pronouns;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public List<Item> getInventory() { return inventory; }

    public int getMoney() { return money; }

    public int getHp() { return hp; }

    public int getStrength() { return strength; }

    public int getAgility() { return agility; }

    public List<Pronouns> getPronouns() { return pronouns; }

    public int getMaxHp() { return maxHp; }

    public PersonDTO toDTO() {
        PersonDTO dto = new PersonDTO() {};
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setInventory(this.inventory);
        dto.setMoney(this.money);
        dto.setHp(this.hp);
        dto.setMaxHp(this.maxHp);
        dto.setStrength(this.strength);
        dto.setAgility(this.agility);
        dto.setPronouns(this.pronouns);
        return dto;
    }
}
