package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO: Request (sin pedir id)
 * (Validando campos)
 */
public record MascotaRequest (
        @NotBlank String nombre,
        @NotBlank String especie,
        @NotBlank String raza,
        @NotBlank String color
){ }
