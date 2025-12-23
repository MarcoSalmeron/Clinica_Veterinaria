package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;

import java.util.List;

public interface ListAllMascotasUseCase {

    List<MascotaResponse> getListOfMascotas();

    List<MascoDuenioResponse> getListOfMascoDuenios();

    List<MascotaResponse> filterMascotasByEspecie(String especie);

    List<MascotaResponse> filterMascotasByRaza(String raza);
}
