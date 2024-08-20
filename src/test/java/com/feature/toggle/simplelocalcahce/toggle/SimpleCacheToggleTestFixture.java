package com.feature.toggle.simplelocalcahce.toggle;

class SimpleCacheToggleTestFixture {
    public static SimpleCacheToggle flag를받아_객체를_생성합니다(boolean flag) {
        return SimpleCacheToggle.builder()
                .id(1L)
                .useYn(flag)
                .build();
    }
}
