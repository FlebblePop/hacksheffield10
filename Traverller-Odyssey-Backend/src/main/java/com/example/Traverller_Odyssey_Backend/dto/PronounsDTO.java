package com.example.Traverller_Odyssey_Backend.dto;

import com.example.Traverller_Odyssey_Backend.domain.Person;
import com.example.Traverller_Odyssey_Backend.domain.Pronouns;

public class PronounsDTO {
    public PronounsDTO() {}

    int id;

    String pronoun;

    Person person;

    public int getId() { return id; }

    public String getPronoun() { return pronoun; }

    public Person getPerson() { return person; }

    public void setId(int id) { this.id = id; }

    public void setPronoun(String pronoun) { this.pronoun = pronoun; }

    public void setPerson(Person person) { this.person = person; }

    public Pronouns toEntity() {
        Pronouns pronouns = new Pronouns();
        pronouns.setId(id);
        pronouns.setPronoun(pronoun);
        pronouns.setPerson(person);
        return pronouns;
    }
}
