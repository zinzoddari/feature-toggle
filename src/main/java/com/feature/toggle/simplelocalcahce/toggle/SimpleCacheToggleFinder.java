package com.feature.toggle.simplelocalcahce.toggle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleCacheToggleFinder {
    private final SimpleCacheToggleRepository simpleCacheToggleRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "toggles-active", key = "#toggleId")
    public boolean isActive(final String toggleId) {
        return simpleCacheToggleRepository.findByToggleId(toggleId)
                .map(SimpleCacheToggle::isUseYn)
                .orElse(false);
    }

    @Transactional
    @CacheEvict(value = "toggles-active", key = "#toggleId")
    public void changeUseYn(final String toggleId) {
        SimpleCacheToggle toggle = simpleCacheToggleRepository.findByToggleId(toggleId)
                .orElseThrow(RuntimeException::new);

        toggle.changeUseYn();
    }
}
