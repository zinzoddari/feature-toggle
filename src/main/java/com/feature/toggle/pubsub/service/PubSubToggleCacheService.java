package com.feature.toggle.pubsub.service;

import com.feature.toggle.pubsub.PubSubToggle;
import com.feature.toggle.pubsub.PubSubToggleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PubSubToggleCacheService {

    private final PubSubToggleRepository pubSubToggleRepository;

    @CachePut(cacheNames = "pubsub-toggle", key = "#toggleId")
    public boolean put(final String toggleId, final boolean useYn) {
        return useYn;
    }

    @Cacheable(cacheNames = "pubsub-toggle", key = "#toggleId")
    public boolean isActive(final String toggleId) {
        return pubSubToggleRepository.findByToggleId(toggleId)
                .map(PubSubToggle::isUseYn)
                .orElse(false);
    }
}
