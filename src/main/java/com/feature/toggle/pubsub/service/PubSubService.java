package com.feature.toggle.pubsub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PubSubService {

    private final PubSubToggleService pubSubToggleService;
    private final PubSubToggleCacheService pubSubToggleCacheService;
    private final PubSubUpdateService toggleUpdateService;

    @Transactional
    public void changeUseYn(final String toggleId) {
        final boolean useYn = pubSubToggleService.changeUseYn(toggleId);

        toggleUpdateService.publish(toggleId, useYn);
    }

    @Transactional(readOnly = true)
    public boolean isActive(final String toggleId) {
        return pubSubToggleCacheService.isActive(toggleId);
    }
}
