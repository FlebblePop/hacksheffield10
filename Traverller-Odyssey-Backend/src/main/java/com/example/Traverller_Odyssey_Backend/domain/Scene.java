package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.SceneDTO;
import com.example.Traverller_Odyssey_Backend.domain.Character;
import jakarta.persistence.*;

import java.util.List;


public class Scene {
    private int id;

    private String imagePath;
    private String introText;

    private List<Character> characters;

    public Scene() {}

    public Scene(int id, String imagePath, String introText, List<Character> characters) {
        this.imagePath = imagePath;
        this.introText = introText;
        this.characters = characters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public SceneDTO toDto() {
        SceneDTO sceneDto = new SceneDTO();

        sceneDto.setId(this.id);
        sceneDto.setImagePath(this.imagePath);

        return sceneDto;
    }
}
