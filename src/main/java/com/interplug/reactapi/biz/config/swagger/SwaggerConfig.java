package com.interplug.reactapi.biz.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()).info(customApiInfo());
    }

    private Info customApiInfo() {
        return new Info().title("React-Beginner-Api Swagger")
                .description("Beginner API , ps, DB조회에 관한 REST API")
                .version("1.0.0");
    }
}
