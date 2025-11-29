package com.example.hack_sheffield_backend.domain;

import com.example.hack_sheffield_backend.dto.CharacterDTO;
import jakarta.persistence.Entity;

@Entity
public class Character extends Person {
    private String prompt;

    public Character() {}

    public Character(String name, String prompt) {
        super(name);

        this.prompt = prompt;
    }

    public String getPrompt() { return this.prompt; }

    public void setPrompt(String prompt) { this.prompt = prompt; }

    public CharacterDTO toDTO() {
        CharacterDTO dto = new CharacterDTO();
        dto.setPrompt(prompt);
        return dto;
    }
}
