package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto;

/**
 * DTO: Response (mostrando id)
 * (solo para vista)
 */
public record MascotaResponse(
        Long idMascota,
        String nombre,
        String especie,
        String raza,
        String color
) { }
