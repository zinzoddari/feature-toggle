package com.feature.toggle.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BusinessServiceTest {

    @Autowired
    private BusinessService businessService;

    @Test
    @DisplayName("활성화 된 토글을 불러옵니다.")
    void activeToggle() {
        //given
        final String toggleId = "SIMPLE-TOGGLE-ONE";

        //when
        final boolean result = businessService.login(toggleId);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("비활성화 된 토글을 불러옵니다.")
    void nonActiveToggle() {
        //given
        final String toggleId = "SIMPLE-TOGGLE-TWO";

        //when
        final boolean result = businessService.login(toggleId);

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("존재하지 않는 토글의 경우 비활성화 처리를 합니다.")
    void invalidToggle() {
        //given
        final String toggleId = "INVALID-TOGGLE-ID";

        //when
        final boolean result = businessService.login(toggleId);

        //then
        assertThat(result).isFalse();
    }
}
