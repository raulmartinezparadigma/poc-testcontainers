package com.eci.poctestcontainers.ms.example.controller.rdto.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Datos de la request para la creación de un Example
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleCreateRQRDTO {


	@JsonProperty(value = "example_name")
	private String exampleName;

}
