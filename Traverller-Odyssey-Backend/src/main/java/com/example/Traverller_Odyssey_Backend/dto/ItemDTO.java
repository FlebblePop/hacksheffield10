package com.example.Traverller_Odyssey_Backend.dto;

import com.example.Traverller_Odyssey_Backend.domain.Item;
import com.example.Traverller_Odyssey_Backend.domain.Person;


public class ItemDTO {
    public ItemDTO() {}

    private int id;

    private String name;

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

    public Item toEntity(){
        Item item = new Item();
        item.setId(this.id);
        item.setName(this.name);
        item.setPerson(this.person);
        return item;
    }
}
