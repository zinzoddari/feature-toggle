package com.feature.toggle.mapchache.controller;

import com.feature.toggle.mapchache.service.MapCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map/toggle")
@RequiredArgsConstructor
public class MapCacheController {

    private final MapCacheService mapCacheService;

    @GetMapping
    public boolean isActive(@RequestParam final String toggleId) {
        return mapCacheService.isActive(toggleId);
    }

    @PutMapping
    public void changeUseYn(@RequestParam final String toggleId) {
        mapCacheService.changeUseYn(toggleId);
    }
}
