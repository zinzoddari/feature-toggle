package com.feature.toggle.simpledate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleDateBusinessServiceTest {

    @Autowired
    private SimpleDateBusinessService simpleDateBusinessService;

    @Nested
    @DisplayName("유효기간이 지났으며")
    class invalidDate {
        @ParameterizedTest
        @ValueSource(strings = {"2023-12-31 23:59:59", "2024-08-18 01:20:00", "2024-01-02 00:00:00"})
        @DisplayName("사용여부가 Y여도 기존 로직을 타야한다.")
        void isY() {
            //given
            final String toggleId = "TOGGLE-ONE";
            final LocalDateTime currentDate = LocalDateTime.of(2024, 8, 18, 1, 20, 0);

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("사용여부가 N일 때, 기존 로직을 탄다.")
        void isN() {
            //given
            final String toggleId = "TOGGLE-TWO";
            final LocalDateTime currentDate = LocalDateTime.of(2024, 8, 18, 1, 20, 0);

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("유효기간이 유효하며")
    class validDate {
        @ParameterizedTest
        @ValueSource(strings = {"2024-08-18 00:00:00", "2024-08-18 12:01:59", "2024-08-18 23:59:59"})
        @DisplayName("사용여부가 Y이며 새로운 로직을 타야한다.")
        void isY(final String parameter) {
            //given
            final String toggleId = "TOGGLE-THREE";
            final LocalDateTime currentDate = LocalDateTime.parse(parameter, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {"2024-08-17 00:00:00", "2024-08-18 12:01:59", "2024-08-18 23:59:59"})
        @DisplayName("사용여부가 N일 때, 기존 로직을 탄다.")
        void isN() {
            //given
            final String toggleId = "TOGGLE-FOUR";
            final LocalDateTime currentDate = LocalDateTime.of(2024, 8, 18, 1, 20, 0);

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isFalse();
        }
    }
}
