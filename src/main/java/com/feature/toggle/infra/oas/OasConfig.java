package com.feature.toggle.infra.oas;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OasConfig {
    @Bean
    public OpenAPI apiConfig() {
        return new OpenAPI()
                .info(new Info().title("FEATURE TOGGLE API"));
    }
}
