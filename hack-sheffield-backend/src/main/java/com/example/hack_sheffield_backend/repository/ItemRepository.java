package com.example.hack_sheffield_backend.repository;

import com.example.hack_sheffield_backend.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
