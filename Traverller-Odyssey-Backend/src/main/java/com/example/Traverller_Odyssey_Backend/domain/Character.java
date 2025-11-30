package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.CharacterDTO;
import jakarta.persistence.Entity;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

import java.util.ArrayList;
import java.util.List;


public class Character extends Person {

    private String prompt;

    private final OpenAIClient client;

    public Character(String name, String prompt) {
        super(name);

        String apiKey = System.getenv("OPENAI_API_KEY");

        this.prompt = prompt;

        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    public String askOpenAI(String prompt) {

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input(this.prompt + prompt)
                .model(ChatModel.GPT_5_MINI)
                .build();

        // StringBuilder to collect all output text
        StringBuilder output = new StringBuilder();

        client.responses().create(createParams).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> {
                    String text = outputText.text();

                    // Append text for returning
                    output.append(text);
                });

        // Return the complete output as a single string
        return output.toString();
    }

    public CharacterDTO toDTO() {
        CharacterDTO dto = new CharacterDTO();
        return dto;
    }
}
