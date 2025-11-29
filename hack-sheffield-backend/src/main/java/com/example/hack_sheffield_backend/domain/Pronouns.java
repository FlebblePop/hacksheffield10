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
}
