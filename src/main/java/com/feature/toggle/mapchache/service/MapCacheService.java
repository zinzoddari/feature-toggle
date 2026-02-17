package com.feature.toggle.mapchache.service;

import com.feature.toggle.mapchache.MapCacheToggleFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapCacheService {
    private final MapCacheToggleFinder mapCacheToggleFinder;

    @Transactional
    public void changeUseYn(final String toggleId) {
        mapCacheToggleFinder.update(toggleId);
    }

    @Transactional(readOnly = true)
    public boolean isActive(final String toggleId) {
        final boolean toggle = mapCacheToggleFinder.isActive(toggleId);

        if (toggle) {
            log.info("!! TRUE");
        } else {
            log.info("FALSE !!");
        }

        return toggle;
    }
}
