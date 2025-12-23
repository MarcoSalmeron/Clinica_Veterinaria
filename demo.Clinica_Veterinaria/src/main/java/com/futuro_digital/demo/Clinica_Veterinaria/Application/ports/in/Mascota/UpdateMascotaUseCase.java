package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;

public interface UpdateMascotaUseCase {

    MascotaResponse updateMascota(MascotaRequest request, Long id);
}
