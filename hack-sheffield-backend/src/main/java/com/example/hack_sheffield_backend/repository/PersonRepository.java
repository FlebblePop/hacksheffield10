package com.example.hack_sheffield_backend.repository;

import com.example.hack_sheffield_backend.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
