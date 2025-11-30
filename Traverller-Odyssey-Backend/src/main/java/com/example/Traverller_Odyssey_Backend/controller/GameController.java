package com.example.Traverller_Odyssey_Backend.controller;

import com.example.Traverller_Odyssey_Backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping({"", "/"})
//@CrossOrigin(origins = "*") // Allow React to connect
public class GameController {

    private final GameService gameService;
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping({"/scene"})
    public @ResponseBody String getIntroText() {
        return gameService.getIntroText();
    }

    @GetMapping(value = "/image")
    public @ResponseBody String getImagePath() {
        return gameService.getImagePath();
    }

    @GetMapping("/{input}")
    public @ResponseBody String processInput(@PathVariable String input) {
        String result = gameService.processInput(input);

        if (result.equals("New Chapter")) {
            notifySceneChange();
        }
        return result;
    }

    @GetMapping(value = "/scene-updates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamSceneUpdates() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError((e) -> emitters.remove(emitter));

        return emitter;
    }

    // Call this method whenever you want to trigger a scene update in React
    public void notifySceneChange() {
        List<SseEmitter> deadEmitters = new ArrayList<>();

        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event()
                        .name("sceneChange")
                        .data("update"));
            } catch (IOException e) {
                deadEmitters.add(emitter);
            }
        });

        emitters.removeAll(deadEmitters);
    }
}