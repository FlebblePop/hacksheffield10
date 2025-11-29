package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.SceneDTO;
import com.example.Traverller_Odyssey_Backend.domain.Character;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imagePath;

    @OneToMany(mappedBy = "id")
    private List<Character> characters;

    public Scene() {}

    public Scene(String imagePath, List<Character> characters) {
        this.imagePath = imagePath;
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
