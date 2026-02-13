package com.feature.toggle.strategy;

import com.feature.toggle.simple.SimpleToggleFinder;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToggleExecutor {

    private final SimpleToggleFinder toggleFinder;
    private final Map<String, TogglePair<?, ?>> registry;

    public <I, O> O run(String toggleId, I input) {
        TogglePair<I, O> pair = (TogglePair<I, O>) registry.get(toggleId);
        if (pair == null) {
            throw new IllegalArgumentException("등록되지 않은 toggleId 입니다: " + toggleId);
        }

        boolean active = toggleFinder.isActive(toggleId);
        return active ? pair.newAction().execute(input)
            : pair.legacyAction().execute(input);
    }
}
