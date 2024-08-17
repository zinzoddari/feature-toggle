package com.feature.toggle.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SimpleToggleFinder {
    private final SimpleToggleRepository simpleToggleRepository;

    @Transactional(readOnly = true)
    public boolean isActive(String toggleId) {
        return simpleToggleRepository.findByToggleId(toggleId)
                .map(SimpleToggle::isUseYn)
                .orElse(false);
    }
}
