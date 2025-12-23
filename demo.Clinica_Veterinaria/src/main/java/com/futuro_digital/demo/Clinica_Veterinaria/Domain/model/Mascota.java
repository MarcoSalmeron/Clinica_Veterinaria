package com.futuro_digital.demo.Clinica_Veterinaria.Domain.model;

import lombok.Builder;

/**
 * Modelo de Dominio del Negocio
 * (sin lógica de negocio adicional requerida)
 */
@Builder
public record Mascota(
        Long id,
        String nombre,
        String especie,
        String raza,
        String color
) { }
