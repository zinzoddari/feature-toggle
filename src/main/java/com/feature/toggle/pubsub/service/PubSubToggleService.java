package com.feature.toggle.pubsub.service;

import com.feature.toggle.pubsub.PubSubToggle;
import com.feature.toggle.pubsub.PubSubToggleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PubSubToggleService {

    private final PubSubToggleRepository pubSubToggleRepository;

    @Transactional
    public boolean changeUseYn(final String toggleId) {
        final PubSubToggle toggle = pubSubToggleRepository.findByToggleId(toggleId)
                .orElseThrow();

        toggle.changeUseYn();

        return toggle.isUseYn();
    }
}
