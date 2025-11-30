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

    private final List<String> chatHistory = new ArrayList<>();


    public Character(String name, String prompt) {
        super(name);

        String apiKey = System.getenv("OPENAI_API_KEY");

        chatHistory.add(prompt);

        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    public String askOpenAI(String userMessage) {

        // Append user message to history
        chatHistory.add("User: " + userMessage);

        // Build the full conversation string
        StringBuilder fullPrompt = new StringBuilder(userMessage);

        for (String msg : chatHistory) {
            fullPrompt.append(msg).append("\n");
        }

        // Build request
        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input(fullPrompt.toString())
                .model(ChatModel.GPT_5_MINI)
                .build();

        StringBuilder output = new StringBuilder();

        client.responses().create(createParams).output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .forEach(outputText -> output.append(outputText.text()));

        // Store the AI response
        String aiReply = output.toString();
        chatHistory.add("AI: " + aiReply);

        System.out.println(aiReply);
        return aiReply;
    }


    public CharacterDTO toDTO() {
        CharacterDTO dto = new CharacterDTO();
        return dto;
    }
}
