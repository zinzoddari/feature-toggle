package com.feature.toggle.simplelocalcahce.service;

import com.feature.toggle.simplelocalcahce.toggle.SimpleCacheToggleFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleCacheToggleService {
    private final SimpleCacheToggleFinder simpleCacheToggleFinder;

    @Transactional(readOnly = true)
    public void logic(final String toggleId) {
        if (simpleCacheToggleFinder.isActive(toggleId)) {
            log.info("TOGGLE STATUS IS ACTIVE ! ! !");

            return;
        }

        log.info("TOGGLE STATUS IS NON-ACTIVE ! ! !");
    }

    @Transactional
    public void changeUseYn(final String toggleId) {
        simpleCacheToggleFinder.changeUseYn(toggleId);
    }
}
