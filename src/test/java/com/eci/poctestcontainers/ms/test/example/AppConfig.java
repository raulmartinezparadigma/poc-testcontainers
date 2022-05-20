package com.eci.poctestcontainers.ms.test.example;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

/**
 * Configuración de spring para el microservicio
 */
@Configuration
@ComponentScan("com.eci.poctestcontainers.ms.example")
public class AppConfig {


}