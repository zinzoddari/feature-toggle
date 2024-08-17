package com.feature.toggle.simpledate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleDateBusinessServiceTest {

    @Autowired
    private SimpleDateBusinessService simpleDateBusinessService;

    @Nested
    @DisplayName("유효기간이 지났으며")
    class invalidDate {
        @Test
        @DisplayName("사용여부가 Y여도 기존 로직을 타야한다.")
        void isY() {
            //given
            final String toggleId = "TOGGLE-ONE";
            final LocalDateTime currentDate = LocalDateTime.now();

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
            final LocalDateTime currentDate = LocalDateTime.now();

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("유효기간이 유효하며")
    class validDate {
        @Test
        @DisplayName("사용여부가 Y이며 새로운 로직을 타야한다.")
        void isY() {
            //given
            final String toggleId = "TOGGLE-THREE";
            final LocalDateTime currentDate = LocalDateTime.now();

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("사용여부가 N일 때, 기존 로직을 탄다.")
        void isN() {
            //given
            final String toggleId = "TOGGLE-FOUR";
            final LocalDateTime currentDate = LocalDateTime.now();

            //when
            final boolean result = simpleDateBusinessService.logic(toggleId, currentDate);

            //then
            assertThat(result).isFalse();
        }
    }
}
