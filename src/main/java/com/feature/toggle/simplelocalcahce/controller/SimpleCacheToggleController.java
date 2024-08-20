package com.feature.toggle.simplelocalcahce.controller;

import com.feature.toggle.simplelocalcahce.service.SimpleCacheToggleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simple/cache")
@Tag(name = "로컬 캐시 토글", description = "로컬 캐시를 이용한 토글 관련 API 입니다.")
public class SimpleCacheToggleController {
    private final SimpleCacheToggleService simpleCacheToggleService;

    @GetMapping
    public void get(@RequestParam(defaultValue = "SIMPLE-CACHE-TOGGLE") final String toggleId) {
        simpleCacheToggleService.logic(toggleId);
    }

    @PutMapping
    public void changeUseYn(@RequestParam(defaultValue = "SIMPLE-CACHE-TOGGLE") final String toggleId) {
        simpleCacheToggleService.changeUseYn(toggleId);
    }
}
