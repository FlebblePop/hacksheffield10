package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Item {
    @Id
    private int id;

    private String name;

    @ManyToOne
    private Player player;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
