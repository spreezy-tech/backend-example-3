package com.backend.restro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("swagger")
    public OpenAPI swaggerSetup(){
        return new OpenAPI().info(
                new Info()
                        .title("Restaurant Mini project")
                        .description("Sample swagger setup")
        );
    }
}
