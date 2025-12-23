package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto;

/**
 * DTO: Response (mostrando id)
 * (solo para vista)
 */
public record DuenioResponse(
        Long idDuenio,
        String dni,
        String nombre,
        String apellido,
        String telefono,
        String email
) { }
