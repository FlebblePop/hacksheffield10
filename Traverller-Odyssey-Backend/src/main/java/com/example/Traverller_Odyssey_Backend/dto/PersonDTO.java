package com.example.Traverller_Odyssey_Backend.dto;

import com.example.Traverller_Odyssey_Backend.domain.Item;
import com.example.Traverller_Odyssey_Backend.domain.Person;
import com.example.Traverller_Odyssey_Backend.domain.Pronouns;


import java.util.ArrayList;
import java.util.List;

public abstract class PersonDTO {
    public PersonDTO() {}

    private int id;
    private String name;


    private List<Item> inventory;

    private int money;
    private int hp;
    private int maxHp;
    private int strength;
    private int agility;


    private List <Pronouns> pronouns;

//    public Person toEntity(String name) {
//        Person person = new Person() {};
//        person.setName(name);
//        person.setInventory(inventory);
//        person.setMoney(money);
//        person.setHp(hp);
//        person.setMaxHp(maxHp);
//        person.setStrength(strength);
//        person.setAgility(agility);
//        person.setPronouns(pronouns);
//        return  person;
//    }

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

}
