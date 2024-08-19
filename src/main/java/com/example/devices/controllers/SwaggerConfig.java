package com.example.devices.controllers;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Devices from Mock Server Documentation")
                        .version("1.0.0")
                        .description("API para traer dispositivos de un Mock Server de Postman"));
    }
}