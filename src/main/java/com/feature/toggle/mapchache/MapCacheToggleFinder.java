package com.feature.toggle.mapchache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MapCacheToggleFinder {

    private final MapToggleSnapshot snapshot;
    private final MapCacheToggleRepository cacheToggleRepository;

    public boolean isActive(final String toggleId) {
        return snapshot.getOrDefault(toggleId);
    }

    public void replaceAll(final Map<String, Boolean> newValues) {
        snapshot.replaceAll(newValues);
    }

    @Transactional
    public void update(final String toggleId) {
        final MapCacheToggle toggle = cacheToggleRepository.findByToggleId(toggleId)
                .orElseThrow();

        toggle.changeUseYn();
    }
}
