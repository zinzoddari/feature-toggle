package com.feature.toggle.pubsub;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PubSubPublisher {

    private final StringRedisTemplate stringRedisTemplate;
    private final ChannelTopic toggleUpdateTopic;

    public void publish(final String toggleId, final boolean useYn) {
        final String payload = toggleId + "|" + useYn;
        stringRedisTemplate.convertAndSend(toggleUpdateTopic.getTopic(), payload);
    }
}
