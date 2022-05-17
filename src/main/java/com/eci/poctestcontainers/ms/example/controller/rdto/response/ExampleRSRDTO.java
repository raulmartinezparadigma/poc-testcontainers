package com.eci.poctestcontainers.ms.example.controller.rdto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Datos de la response para la consulta de un Example
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExampleRSRDTO {

	@JsonProperty(value = "example_id")
	private String exampleId;
	
	@JsonProperty(value = "example_name")
	private String exampleName;
}
