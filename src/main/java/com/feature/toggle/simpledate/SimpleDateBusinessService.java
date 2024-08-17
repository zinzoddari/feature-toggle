package com.feature.toggle.simpledate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleDateBusinessService {
    private final SimpleDateToggleFinder simpleDateToggleFinder;

    @Transactional(readOnly = true)
    public boolean logic(final String toggleId, final LocalDateTime currentDate) {
        if (simpleDateToggleFinder.isActive(toggleId, currentDate)) {
            log.info("TOGGLE STATUS IS ACTIVE ! ! !");

            return true;
        }

        log.info("TOGGLE STATUS IS NON-ACTIVE ! ! !");
        return false;
    }
}
