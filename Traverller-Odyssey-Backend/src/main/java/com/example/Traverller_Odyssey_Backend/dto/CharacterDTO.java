package com.example.Traverller_Odyssey_Backend.dto;

import com.example.Traverller_Odyssey_Backend.domain.Character;

public class CharacterDTO extends PersonDTO {
    public CharacterDTO() {}

    private String prompt;

    public String getPrompt() { return prompt; }

    public void setPrompt(String prompt) { this.prompt = prompt; }

    public Character toEntity() {
        Character character = new Character();
        character.setPrompt(this.prompt);
        return character;
    }

}
