package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Character {
    @Id
    private int id;

    private String name;
    private List<Item> inventory;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
