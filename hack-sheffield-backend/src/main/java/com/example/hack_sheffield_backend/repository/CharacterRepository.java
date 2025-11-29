package com.example.hack_sheffield_backend.repository;

import com.example.hack_sheffield_backend.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
