package com.example.hack_sheffield_backend.domain;

import jakarta.persistence.*;

@Entity
public class Pronouns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  id;
    String pronoun;

    @ManyToOne
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
}
