package com.eci.poctestcontainers.ms.example.service;

import com.eci.poctestcontainers.ms.example.service.dto.input.ExampleCreateIDTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleCreateODTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleODTO;
import org.springframework.stereotype.Service;


@Service
public class ExampleServiceImpl implements ExampleService {



	/**
	 * Creación de un Example
	 *
	 * @param exampleCreateIDTO
	 */
	public ExampleCreateODTO createExample(ExampleCreateIDTO exampleCreateIDTO) {
		return null;
	}

	/**
	 * Consulta por id de un Example
	 *
	 * @param exampleId
	 */
	public ExampleODTO findExample(String exampleId) {
		return null;
	}
}
