package com.example.hack_sheffield_backend.dto;

import com.example.hack_sheffield_backend.domain.Scene;

import java.util.List;

public class SceneDTO {

    private int id;
    private String imagePath;
    private List<Integer> characterIds;

    public SceneDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Integer> getCharacterIds() {
        return characterIds;
    }

    public void setCharacterIds(List<Integer> characterIds) {
        this.characterIds = characterIds;
    }

    public Scene toEntity() {
        Scene scene = new Scene();

        scene.setId(id);
        scene.setImagePath(imagePath);

        return scene;
    }
}
