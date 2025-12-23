package com.futuro_digital.demo.Clinica_Veterinaria.Domain.service;

import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Duenio;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Mascota;

/**
 * Validar todos los atributos del modelo de negocio (sin id)
 */
public class DomainServiceValidator {

    public static boolean isDuenioValid(Duenio duenio){
        return duenio.dni() != null && duenio.nombre() != null && duenio.apellido() != null && duenio.telefono() != null && duenio.email() != null;
    }

    public static boolean isMascotaValid(Mascota ms){
        return ms.nombre() != null && ms.especie() != null & ms.raza() != null && ms.color() != null;
    }
}
