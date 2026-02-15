package com.feature.toggle.mapchache;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class MapToggleSnapshot {

    private volatile Map<String, Boolean> ref = Collections.emptyMap();

    public boolean getOrDefault(final String toggleId) {
        return ref.getOrDefault(toggleId, false);
    }

    public void replaceAll(final Map<String, Boolean> newValues) {
        ref = newValues;
    }
}
