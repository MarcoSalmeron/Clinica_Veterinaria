package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto;

/**
 * DTO: Response (Mascotas con sus Dueños)
 * (solo para vista)
 */
public record MascoDuenioResponse(
        String nombre_mascota,
        String especie,
        String raza,
        String nombre_duenio,
        String apellido_duenio,
        String telefono
) { }
