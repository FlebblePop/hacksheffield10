package com.example.Traverller_Odyssey_Backend.domain;

import com.example.Traverller_Odyssey_Backend.dto.CharacterDTO;
import jakarta.persistence.Entity;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;

import java.util.ArrayList;
import java.util.List;


public class Character extends Person {
    private final ChatClient chatClient;
    private final List<Message> conversation;

    public Character(String name, String prompt, ChatClient.Builder chatClientBuilder) {
        super(name);

        this.chatClient = chatClientBuilder.build();
        final String systemMessageString = prompt;
        this.conversation = new ArrayList<>();
        final SystemMessage systemMessage = new SystemMessage(systemMessageString);
        this.conversation.add(systemMessage);
    }

    public String getAnswer(String message) {
        final Message userMessage = new UserMessage(message);
        this.conversation.add(userMessage);

        String modelResponse = this.chatClient.prompt()
                .messages(this.conversation)
                .call()
                .content();
        final Message assistantMessage = new AssistantMessage(modelResponse);
        this.conversation.add(assistantMessage);
        return modelResponse;
    }

    public CharacterDTO toDTO() {
        CharacterDTO dto = new CharacterDTO();
        return dto;
    }
}
