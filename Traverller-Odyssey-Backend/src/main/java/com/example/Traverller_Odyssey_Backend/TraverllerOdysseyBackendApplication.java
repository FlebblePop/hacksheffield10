package com.example.Traverller_Odyssey_Backend;

import com.example.Traverller_Odyssey_Backend.domain.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Traverller_Odyssey_Backend.domain.Scene;
import com.example.Traverller_Odyssey_Backend.domain.Character;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class TraverllerOdysseyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraverllerOdysseyBackendApplication.class, args);
	}
}
