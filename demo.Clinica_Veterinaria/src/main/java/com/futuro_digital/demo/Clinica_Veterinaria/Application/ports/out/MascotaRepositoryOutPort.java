package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out;

import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Mascota;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;

import java.util.List;

/**
 * Puerto de Salida: Mascota
 * ( usa el modelo del dominio )
 */
public interface MascotaRepositoryOutPort {

    Mascota createMascota(Mascota mascota, Long id_duenio);

    List<Mascota> getAllMascotas();

    List<MascoDuenioResponse> getListOfMascoDuenios();

    Mascota findByDuenio(Long id_duenio);

    List<Mascota> filterByEspecie(String especie);

    List<Mascota> filterByRaza(String raza);

    Mascota findMascota(Long id);

    Mascota updateMascota(Mascota mascota, Long id);

    void deleteMascota(Long id);
}
