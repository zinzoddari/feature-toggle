package com.feature.toggle.mapchache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MapCacheToggleRefresher {

    private final MapCacheToggleRepository repository;
    private final MapCacheToggleFinder finder;

    @Scheduled(initialDelayString = "0", fixedDelayString = "${toggle.cache.refresh-delay-ms:10000}")
    @Transactional(readOnly = true)
    public void refresh() {
        final Map<String, Boolean> values = repository.findAll().stream()
                .collect(Collectors.toMap(
                        MapCacheToggle::getToggleId,
                        MapCacheToggle::isUseYn
                ));

        finder.replaceAll(values);
    }
}
