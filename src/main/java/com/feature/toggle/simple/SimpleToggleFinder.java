package com.feature.toggle.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class SimpleToggleFinder {
    private final SimpleToggleRepository simpleToggleRepository;

    @Transactional(readOnly = true)
    public boolean isActive(String toggleId) {
        SimpleToggle toggle = simpleToggleRepository.findByToggleId(toggleId);

        if(ObjectUtils.isEmpty(toggle)) {
            return false;
        }

        return toggle.isUseYn();
    }
}
