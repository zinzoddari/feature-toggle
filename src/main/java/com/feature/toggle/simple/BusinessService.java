package com.feature.toggle.simple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessService {
    private final SimpleToggleFinder simpleToggleFinder;

    @Transactional(readOnly = true)
    public boolean login(final String toggleId) {
        if (simpleToggleFinder.isActive(toggleId)) {
            log.info("TOGGLE STATUS IS ACTIVE ! ! !");

            return true;
        }

        log.info("TOGGLE STATUS IS NON-ACTIVE ! ! !");
        return false;
    }
}
