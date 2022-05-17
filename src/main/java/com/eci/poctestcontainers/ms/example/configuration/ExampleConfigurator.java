package com.eci.poctestcontainers.ms.example.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Configuración de spring para el microservicio
 */
@Configuration
@ComponentScan("com.eci.poctestcontainers.ms.example")
public class ExampleConfigurator {
    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        dataSourceBuilder.url("jdbc:oracle:thin:@pgpservicesenv:1521/XE");
        dataSourceBuilder.username("paradigma");
        dataSourceBuilder.password("paradigma");
        return dataSourceBuilder.build();
    }

}
