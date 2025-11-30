package com.example.Traverller_Odyssey_Backend.domain;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;

import java.util.ArrayList;
import java.util.List;


public class Character extends Person {

    private String prompt;

    private final OpenAIClient client;

    // Add: in-memory chat history to preserve conversation context
    private final List<ChatMessage> chatHistory = new ArrayList<>();

    public Character(String name, String prompt) {
        super(name);

        String apiKey = System.getenv("OPENAI_API_KEY");

        this.prompt = prompt;

        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }

    public String getPrompt() {return prompt;}

    public String askOpenAI(String userMessage) {
        System.out.println("_History with " + getName() +"_ ");
        printHistory();
        // Add the new user message to history
        chatHistory.add(new ChatMessage("user", userMessage));

        // Build a single combined prompt: system prompt + alternating history entries
        StringBuilder combined = new StringBuilder();
        if (this.prompt != null && !this.prompt.isEmpty()) {
            combined.append("System: ").append(this.prompt.trim()).append("\n\n");
        }

        for (ChatMessage m : chatHistory) {
            if ("user".equalsIgnoreCase(m.role)) {
                combined.append("User: ").append(m.content.trim()).append("\n\n");
            } else {
                combined.append("Assistant: ").append(m.content.trim()).append("\n\n");
            }
        }

        // Build request
        ResponseCreateParams createParams = ResponseCreateParams.builder()
                .input(combined.toString())
                .model(ChatModel.GPT_5_NANO)
                .build();

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

        String assistantReply = output.toString().trim();

        // Append assistant reply to history so next call has context
        if (!assistantReply.isEmpty()) {
            chatHistory.add(new ChatMessage("assistant", assistantReply));
        }

        // Return the complete output as a single string
        if (assistantReply.contains(":") && assistantReply.contains(getName())) {
            assistantReply = assistantReply.substring(assistantReply.indexOf(":") + 1);
        }
        return assistantReply;
    }

    // Optional helper to clear chat history
    public void resetHistory() {
        chatHistory.clear();
    }

    public void printHistory() {
        StringBuilder combined = new StringBuilder();

        for (ChatMessage m : chatHistory) {
            if ("user".equalsIgnoreCase(m.role)) {
                combined.append("User: ").append(m.content.trim()).append("\n\n");
            } else {
                combined.append("Assistant: ").append(m.content.trim()).append("\n\n");
            }
        }

        System.out.println(combined.toString());
    }

    // Lightweight inner message class for role/content
    private static class ChatMessage {
        final String role;
        final String content;

        ChatMessage(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
