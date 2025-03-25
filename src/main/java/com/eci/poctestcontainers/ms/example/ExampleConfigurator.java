package com.eci.poctestcontainers.ms.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de spring para el microservicio
 */
@Configuration
@ComponentScan("com.eci.poctestcontainers.ms.example")
public class ExampleConfigurator {
    // La configuración de la base de datos se ha movido a application.properties
}
