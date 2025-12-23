package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;

public interface FindMascotaUseCase {

    MascotaResponse findMascota(Long id);

    MascotaResponse findByDuenio(Long id);
}
