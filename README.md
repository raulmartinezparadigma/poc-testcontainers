## Microservice de Example


## Instrucciones básicas (BETA)


 - Crear una carpeta -> mkdir poc-testcontainers
 - Entrar en la carpeta creada -> cd poc-testcontainers
 - Descargar los proyectos:

```
 	git clone ssh://git@bitbucket.almeci.io:7999/poc-testcontainers/poc-testcontainers-ms-example.git
 	git clone ssh://git@bitbucket.almeci.io:7999/poc-testcontainers/scripts.git
 	git clone ssh://git@bitbucket.almeci.io:7999/poc-testcontainers/poc-testcontainers-libs.git
 	git clone ssh://git@bitbucket.almeci.io:7999/poc-testcontainers/miscellaneous.git
```

 - Muy importante respetar las capas de la Arquitectura y la nomenclatura:
 	
 	- I/O DTO Input Output DTO
 	- RQ/RS DTO Request Response DTO
 	- Cuidado con la paquetería, intentar respetarla.
 	- Cuidado con las capas y el aislamiento de las mismas.
 	- Organización de Test semejante a la del código
 	

Es importarte respetar los nombres de los artefactos ya que influyen en la composición de los dockers.

Para arrancar el microservicio en local se debe desactivar el _profile_ de Maven **ci** (activado por defecto para evitar parametrizaciones en los entornos de integración) 
y usar el profile **local**.

### Servicios disponibles 

 - Ejemplo examples por POST ver colección de Postman en Miscellaneous
 
### DCOS

Descriptor de DCOS en la carpeta dcos/dcos.json para los despliegues.

### Docker

> Añade a tu Host

	192.168.180.131 dcos-registry.pre.eci.geci
	10.252.16.15 dcos.pre.eci.geci 
	92.168.50.140 proxycorp.geci


### Integración con satelite-libs
https://gitlab.eci.geci/satelite-libs/satelite-libs



