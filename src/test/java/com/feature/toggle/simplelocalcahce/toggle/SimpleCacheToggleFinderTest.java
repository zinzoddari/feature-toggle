package com.feature.toggle.simplelocalcahce.toggle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleCacheToggleFinderTest {
    @Autowired
    private SimpleCacheToggleFinder simpleCacheToggleFinder;

    @Autowired
    private CacheManager cacheManager;

    final String toggleName = "toggles-active";

    @Nested
    @DisplayName("토글을 조회할 때,")
    class isActive {
        @Test
        @DisplayName("조회한 이력이 없을 경우 캐시에 저장되지 않는다.")
        void notSaveCache() {
            //given
            final String toggleId = "SIMPLE-CACHE-TOGGLE";

            //when & then
            assertThrows(NullPointerException.class, () -> cacheManager.getCache(toggleName).get(toggleId).get());
        }

        @Test
        @DisplayName("한 번 조회하면 캐시에 값이 저장 된다.")
        void usedCached() {
            //given
            final String toggleId = "SIMPLE-CACHE-TOGGLE";

            simpleCacheToggleFinder.isActive(toggleId);

            //when
            final boolean result = (Boolean) Objects.requireNonNull(cacheManager.getCache(toggleName).get(toggleId)).get();

            //then
            assertThat(result).isTrue();
        }
    }
}