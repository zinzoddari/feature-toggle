package com.feature.toggle.pubsub.controller;

import com.feature.toggle.pubsub.service.PubSubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pubsub/toggle")
@RequiredArgsConstructor
public class PubSubController {

    private final PubSubService pubSubService;

    @PutMapping
    public void changeUseYn(@RequestParam final String toggleId) {
        pubSubService.changeUseYn(toggleId);
    }

    @GetMapping
    public boolean isActive(@RequestParam final String toggleId) {
        return pubSubService.isActive(toggleId);
    }
}
