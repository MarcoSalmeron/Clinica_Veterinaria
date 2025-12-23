package com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Duenio;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioResponse;

import java.util.List;

public interface ListAllDueniosUseCase {

    List<DuenioResponse> getListOfDuenios();
}
