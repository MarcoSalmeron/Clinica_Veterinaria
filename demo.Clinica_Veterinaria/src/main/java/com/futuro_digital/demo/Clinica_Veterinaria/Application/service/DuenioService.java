package com.futuro_digital.demo.Clinica_Veterinaria.Application.service;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Duenio.*;
import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out.DuenioRepositoryOutPort;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioResponse;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Parsea DTO Request al modelo de dominio
 * return DTO Response
 */
@Service
@RequiredArgsConstructor
public class DuenioService implements CreateDuenioUseCase, FindDuenioUseCase, UpdateDuenioUseCase, ListAllDueniosUseCase, DeleteDuenioUseCase {

    /**
     * Dependencia:
     * Implementar los puertos de entrada: "UseCase" con el puerto de salida: "OutPort"
     */
    private final DuenioRepositoryOutPort duenioRepositoryOutPort;

    @Override
    public DuenioResponse createDuenio(DuenioRequest request) {
        return RequestMapper.toResponse(duenioRepositoryOutPort.createDuenio(RequestMapper.toDomain(request)));
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepositoryOutPort.deleteDuenio(id);
    }

    @Override
    public DuenioResponse findDuenio(Long id) {
        return RequestMapper.toResponse(duenioRepositoryOutPort.findDuenio(id));
    }

    @Override
    public DuenioResponse findDuenio(String email) {
        return RequestMapper.toResponse(duenioRepositoryOutPort.findDuenio(email));
    }

    @Override
    public List<DuenioResponse> getListOfDuenios() {
        return RequestMapper.duenioListMapperToReponse(duenioRepositoryOutPort.getAllDuenios());
    }

    @Override
    public DuenioResponse updateDuenio(DuenioRequest request, Long id) {
        return RequestMapper.toResponse(duenioRepositoryOutPort.updateDuenio(RequestMapper.toDomain(request),id));
    }
}
