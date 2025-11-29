package com.example.hack_sheffield_backend.service;

import com.example.hack_sheffield_backend.repository.ItemRepository;
import com.example.hack_sheffield_backend.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
