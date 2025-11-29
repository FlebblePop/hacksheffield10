package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.ItemDTO;
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
    private Person person;

    public void setPerson(Person person) { this.person = person; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {}

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public Person getPerson() { return this.person; }

    public ItemDTO toDto() {
        ItemDTO dto = new ItemDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setPerson(this.person);
        return dto;
    }

}
