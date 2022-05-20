package com.eci.poctestcontainers.ms.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * Aplicación Spring boot para arrancar.
 * 
 * Cargaremos la auto configuración añadiendo los xml por convención que correspondan
 * 
 * Notas:<br/>
 * - Si el MS no tiene autenticación JWT, quitar SecurityConfigurator.class del import y excluir SecurityAutoConfiguration.class de la autoconfiguración
 *
 */
@EnableAutoConfiguration
@Import({ ExampleConfigurator.class})
public class ExampleApplication {



	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ExampleApplication.class, args);
	}




}
