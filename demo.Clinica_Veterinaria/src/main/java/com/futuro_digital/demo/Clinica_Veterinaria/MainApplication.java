package com.futuro_digital.demo.Clinica_Veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	/**
	 * Prueba Técnica con "Despliegue Local" de TodoCodeAcademy
	 *
	 * App para gestión de clínica veterinaria:
	 *   -con CRUD para Dueños y Mascotas
	 *   -relación 1:1
	 *   -conexión a BBDD (PostgreSQL)
	 *   -API tipo REST
	 *   -contenerización con Docker
	 *   -arquitectura de Puertos y Adaptadores (Hexagonal)
	 *   -clean code
	 *   -programación funcional
	 */


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
