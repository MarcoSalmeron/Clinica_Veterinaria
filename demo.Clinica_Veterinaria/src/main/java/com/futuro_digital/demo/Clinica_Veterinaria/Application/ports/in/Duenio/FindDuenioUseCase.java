package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Duenio;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioResponse;

public interface FindDuenioUseCase {

    DuenioResponse findDuenio(Long id);

    DuenioResponse findDuenio(String email);
}
