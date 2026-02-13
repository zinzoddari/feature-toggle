package com.feature.toggle.strategy;

import com.feature.toggle.simple.SimpleToggleFinder;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToggleRegistryConfig {

    @Bean
    public ToggleExecutor toggleExecutor(final SimpleToggleFinder toggleFinder) {

        final Map<String, EnumMap<ToggleState, Supplier<?>>> registry = new HashMap<>();

        // 예: LOGIN 토글
        EnumMap<ToggleState, Supplier<?>> loginActions = new EnumMap<>(ToggleState.class);
        loginActions.put(ToggleState.ACTIVE, () -> newLoginService.login());
        loginActions.put(ToggleState.INACTIVE, () -> legacyLoginService.login());
        registry.put("LOGIN_TOGGLE", loginActions);

        // 다른 토글도 같은 패턴으로 추가 가능
        // registry.put("SOME_TOGGLE", someActions);

        return new ToggleExecutor(toggleFinder, registry);
    }
}
