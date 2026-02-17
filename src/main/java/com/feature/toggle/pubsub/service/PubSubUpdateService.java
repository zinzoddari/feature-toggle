package com.feature.toggle.pubsub.service;

import com.feature.toggle.pubsub.PubSubPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PubSubUpdateService {

    private final PubSubPublisher toggleUpdatePublisher;

    public void publish(final String toggleId, final boolean useYn) {
        toggleUpdatePublisher.publish(toggleId, useYn);
    }
}
