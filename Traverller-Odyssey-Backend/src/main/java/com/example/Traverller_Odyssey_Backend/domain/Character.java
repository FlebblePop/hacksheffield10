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
    private final List<String> chatHistory = new ArrayList<>();

    private final OpenAIClient client;

    public Character(String name, String prompt) {
        super(name);

        String apiKey = System.getenv("OPENAI_API_KEY");
        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();

        chatHistory.add(prompt);
    }

    public String askOpenAI(String prompt) {

        StringBuilder fullPrompt = new StringBuilder();
        fullPrompt.append("Your characters background: ");
        fullPrompt.append(chatHistory.get(0));
        fullPrompt.append("\nPrevious chat history:\n");
        for (int i = 1; i < chatHistory.size(); i++) {
            if ((i & 2) == 0) {
                fullPrompt.append("Traveller: ");
            }
            else {
                fullPrompt.append("You: ");
            }
            fullPrompt.append(i).append("\n");
        }

        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input(prompt)
                .model(ChatModel.GPT_5)
                .build();

        System.out.println(fullPrompt.toString());

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
