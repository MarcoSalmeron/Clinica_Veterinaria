package com.futuro_digital.demo.Clinica_Veterinaria.Domain.model;

import lombok.Builder;

/**
 * Modelo de Dominio del Negocio
 * (sin lógica de negocio adicional requerida)
 */
@Builder
public record Duenio(
        Long id,
        String dni,
        String nombre,
        String apellido,
        String telefono,
        String email
) { }
