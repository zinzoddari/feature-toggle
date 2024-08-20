package com.feature.toggle.simplelocalcahce.toggle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCacheToggleTest {
    @Nested
    @DisplayName("사용여부를 바꿀 때,")
    class changeYn {
        @Test
        @DisplayName("true이면 false를 반환합니다.")
        void changeFalse() {
            //given
            final boolean request = true;
            final SimpleCacheToggle toggle = SimpleCacheToggleTestFixture.flag를받아_객체를_생성합니다(request);

            //when
            toggle.changeUseYn();

            //then
            assertThat(toggle.isUseYn()).isFalse();
        }

        @Test
        @DisplayName("false이면 true를 반환합니다.")
        void changeTrue() {
            //given
            final boolean request = false;
            final SimpleCacheToggle toggle = SimpleCacheToggleTestFixture.flag를받아_객체를_생성합니다(request);

            //when
            toggle.changeUseYn();

            //then
            assertThat(toggle.isUseYn()).isTrue();
        }
    }
}
