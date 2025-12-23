package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out;

import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Duenio;

import java.util.List;

/**
 * Puerto de Salida: Dueño
 * ( usa el modelo del dominio )
 */
public interface DuenioRepositoryOutPort {

    Duenio createDuenio(Duenio duenio);

    List<Duenio> getAllDuenios();

    Duenio findDuenio(Long id);

    Duenio findDuenio(String email);

    Duenio updateDuenio(Duenio duenio, Long id);

    void deleteDuenio(Long id);
}
