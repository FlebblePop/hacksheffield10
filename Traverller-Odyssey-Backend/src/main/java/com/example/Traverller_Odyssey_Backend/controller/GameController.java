package com.example.Traverller_Odyssey_Backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"", "/"})
public class GameController {

    @GetMapping("/{input}")
    public ResponseEntity<> processInput(@PathVariable String input) {}
}
