package com.eci.poctestcontainers.ms.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eci.poctestcontainers.ms.example.controller.rdto.request.ExampleCreateRQRDTO;
import com.eci.poctestcontainers.ms.example.controller.rdto.response.ExampleCreateRSRDTO;
import com.eci.poctestcontainers.ms.example.controller.rdto.response.ExampleRSRDTO;
import com.eci.poctestcontainers.ms.example.service.ExampleService;
import com.eci.poctestcontainers.ms.example.service.dto.input.ExampleCreateIDTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleCreateODTO;
import com.eci.poctestcontainers.ms.example.service.dto.output.ExampleODTO;


/**
 * API para el microservicio de Example
 */
@RestController
public class ExampleController {

	private static final Logger LOG = LoggerFactory.getLogger(ExampleController.class);

	/** Path base de nuestro controlador */
	public static final String PATH = "/examples";

	@Autowired
	private ExampleService exampleService;


	@PostMapping(path = PATH)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ExampleCreateRSRDTO createExample(@RequestBody  ExampleCreateRQRDTO exampleCreateRQRDTO) {

		LOG.debug("Solicitada creación de example: {} ", exampleCreateRQRDTO);

		ExampleCreateIDTO exampleCreateIDTO = new ExampleCreateIDTO();
		ExampleCreateODTO exampleCreateODTO = exampleService.createExample(exampleCreateIDTO);
		ExampleCreateRSRDTO exampleCreateRSRDTO =new ExampleCreateRSRDTO();

		LOG.debug("Finalizada creación del registro: {} ", exampleCreateRSRDTO);

		return exampleCreateRSRDTO;
	}

}
