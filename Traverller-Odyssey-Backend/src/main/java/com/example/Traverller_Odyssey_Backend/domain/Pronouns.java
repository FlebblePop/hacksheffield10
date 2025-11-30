package com.example.Traverller_Odyssey_Backend.domain;

import jakarta.persistence.*;


public class Pronouns {
    int  id;
    String pronoun;

    Person person;

    public Pronouns() {}

    public Pronouns(String pronoun, Person person) {
        this.pronoun = pronoun;
    }

    public Person getPerson() { return person; }

    public int getId() { return id; }

    public String getPronoun() { return pronoun; }

    public void setId(int id) { this.id = id; }

    public void setPronoun(String pronoun) { this.pronoun = pronoun; }

    public void setPerson(Person person) { this.person = person; }

    @Override
    public String toString() {
        return pronoun;
    }
}
