package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO: Request (sin pedir id)
 * (Validando campos)
 */
public record DuenioRequest(
        @NotBlank String dni,
        @NotBlank String nombre,
        @NotBlank String apellido,
        @NotBlank String telefono,
        @NotBlank @Email String email
) { }
