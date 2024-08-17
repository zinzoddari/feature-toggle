package com.feature.toggle.simpledate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SimpleDateToggleFinder {
    private final SimpleDateToggleRepository simpleDateToggleRepository;

    @Transactional(readOnly = true)
    public boolean isActive(final String toggleId, final LocalDateTime currentDate) {
        return simpleDateToggleRepository.findByToggleIdAndDateRage(toggleId, currentDate)
                .map(SimpleDateToggle::isUseYn)
                .orElse(false);
    }
}
