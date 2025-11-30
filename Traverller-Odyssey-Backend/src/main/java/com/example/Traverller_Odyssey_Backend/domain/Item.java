package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.ItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Item {
    private int id;

    private String name;

    public Item(int id, String name) {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {}

    public int getId() {
        return id;
    }

    public String getName() { return name; }
}
