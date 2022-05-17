package com.eci.poctestcontainers.ms.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eci.poctestcontainers.ms.example.service.dto.input.ExampleCreateIDTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleCreateODTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleODTO;

/**
 * Servicio de Example
 *
 */
public interface ExampleService {

	Logger LOG = LoggerFactory.getLogger(ExampleService.class);

	/**
	 * Creación de un Example
	 */
	ExampleCreateODTO createExample(ExampleCreateIDTO exampleCreateIDTO);

	/**
	 * Consulta por id de un Example
	 */
	ExampleODTO findExample(String exampleId);

}
