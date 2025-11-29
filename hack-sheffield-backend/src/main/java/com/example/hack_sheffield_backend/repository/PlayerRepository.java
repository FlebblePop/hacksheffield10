package com.example.hack_sheffield_backend.repository;

import com.example.hack_sheffield_backend.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
