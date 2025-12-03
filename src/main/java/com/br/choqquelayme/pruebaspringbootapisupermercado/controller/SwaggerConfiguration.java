package com.br.choqquelayme.pruebaspringbootapisupermercado.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Super Mercado")
                .version("1.0.0")
                .description("API para la gestión de un supermercado, como lo que es Venta, Producto y Sucursales")
            );
    }
}
