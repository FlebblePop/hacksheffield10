package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Character extends Person {
    private String prompt;

    public Character() {}

    public Character(String name, String prompt) {
        super(name);

        this.prompt = prompt;
    }
}
