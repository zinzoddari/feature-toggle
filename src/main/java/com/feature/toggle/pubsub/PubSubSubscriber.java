package com.feature.toggle.pubsub;

import com.feature.toggle.pubsub.service.PubSubToggleCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PubSubSubscriber {

    private final PubSubToggleCacheService pubSubToggleCacheService;

    public void handleMessage(final String message) {
        final ToggleMessage parsed = ToggleMessage.from(message);

        if (parsed == null) {
            log.warn("유효하지 않은 Pub/Sub 토글 메시지입니다.: {}", message);
            return;
        }

        pubSubToggleCacheService.put(parsed.toggleId(), parsed.useYn());
    }

    private record ToggleMessage(String toggleId, boolean useYn) {

        private static ToggleMessage from(final String message) {
            if (message == null || message.isBlank()) {
                return null;
            }

            final int separatorIndex = message.lastIndexOf('|');
            if (separatorIndex <= 0 || separatorIndex == message.length() - 1) {
                return null;
            }

            final String toggleId = message.substring(0, separatorIndex);
            final String useYnText = message.substring(separatorIndex + 1);
            final boolean useYn = Boolean.parseBoolean(useYnText);

            return new ToggleMessage(toggleId, useYn);
        }
    }
}
