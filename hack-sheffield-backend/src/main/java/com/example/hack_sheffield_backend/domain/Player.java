package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
