package com.example.prestamos.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration{

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Préstamos de Herramientas")
                        .version("1.0.0")
                        .description("Documentación oficial de la API REST para el control de inventario y préstamos del laboratorio tecnológico."));
    }
}