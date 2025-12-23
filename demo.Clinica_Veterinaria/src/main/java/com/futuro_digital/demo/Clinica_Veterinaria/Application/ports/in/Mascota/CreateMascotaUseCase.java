package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;

public interface CreateMascotaUseCase {

    MascotaResponse createMascota(MascotaRequest request, Long idDuenio);
}
