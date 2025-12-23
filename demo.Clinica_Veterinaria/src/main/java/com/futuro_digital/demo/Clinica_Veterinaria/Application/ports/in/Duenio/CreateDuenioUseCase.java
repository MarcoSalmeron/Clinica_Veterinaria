package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Duenio;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioResponse;

public interface CreateDuenioUseCase {

    DuenioResponse createDuenio(DuenioRequest request);
}
