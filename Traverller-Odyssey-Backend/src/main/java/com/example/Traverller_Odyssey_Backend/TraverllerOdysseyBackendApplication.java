package com.example.Traverller_Odyssey_Backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.hack_sheffield_backend.domain.Scene;
import com.example.hack_sheffield_backend.domain.Character;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class TraverllerOdysseyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraverllerOdysseyBackendApplication.class, args);
	}

    @Bean
    public CommandLineRunner CommandLineRunner() {
        return args -> {
            // Create characters
            Character gemini = new Character("Gemini", "");
            Character chatgpt = new Character("ChatGPT", "");
            Character boatSeller = new Character("BoatSeller", "");
            Character pirate1 = new Character("Pirate1", "");
            Character pirate2 = new Character("Pirate2", "");
            Character pirate3 = new Character("Pirate3", "");
            Character rescuer = new Character("Rescuer", "");

            // Create scenes
            Scene scene1 = new Scene("", new ArrayList<>(Arrays.asList(gemini, chatgpt, boatSeller)));
            Scene scene2 = new Scene("",
                    new ArrayList<>(Arrays.asList(gemini, chatgpt, pirate1, pirate2, pirate3)));
            Scene scene3 = new Scene("", new ArrayList<>(Arrays.asList(gemini, chatgpt)));
            Scene scene4 = new Scene("", new ArrayList<>(Arrays.asList(gemini, chatgpt, rescuer)));
        };
    }
}
