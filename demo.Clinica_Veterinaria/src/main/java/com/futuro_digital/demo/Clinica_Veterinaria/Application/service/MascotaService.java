package com.futuro_digital.demo.Clinica_Veterinaria.Application.service;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota.*;
import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out.MascotaRepositoryOutPort;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;
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
public class MascotaService implements CreateMascotaUseCase, FindMascotaUseCase, UpdateMascotaUseCase, ListAllMascotasUseCase, DeleteMascotaUseCase {

    /**
     * Dependencia:
     * Implementar los puertos de entrada: "UseCase" con el puerto de salida: "OutPort"
     */
    private final MascotaRepositoryOutPort mascotaRepositoryOutPort;

    @Override
    public MascotaResponse createMascota(MascotaRequest request, Long idDuenio) {
        return RequestMapper.toResponse(mascotaRepositoryOutPort.createMascota(RequestMapper.toDomain(request),idDuenio));
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepositoryOutPort.deleteMascota(id);
    }

    @Override
    public MascotaResponse findMascota(Long id) {
        return RequestMapper.toResponse(mascotaRepositoryOutPort.findMascota(id));
    }

    @Override
    public List<MascotaResponse> getListOfMascotas() {
        return RequestMapper.mascotaListMapperToResponse(mascotaRepositoryOutPort.getAllMascotas());
    }

    @Override
    public List<MascoDuenioResponse> getListOfMascoDuenios() {
        return mascotaRepositoryOutPort.getListOfMascoDuenios();
    }

    @Override
    public List<MascotaResponse> filterMascotasByEspecie(String especie) {
        return RequestMapper.mascotaListMapperToResponse(mascotaRepositoryOutPort.filterByEspecie(especie));
    }

    @Override
    public List<MascotaResponse> filterMascotasByRaza(String raza) {
        return RequestMapper.mascotaListMapperToResponse(mascotaRepositoryOutPort.filterByRaza(raza));
    }

    @Override
    public MascotaResponse findByDuenio(Long idDuenio) {
        return RequestMapper.toResponse(mascotaRepositoryOutPort.findByDuenio(idDuenio));
    }

    @Override
    public MascotaResponse updateMascota(MascotaRequest request, Long id) {
        return RequestMapper.toResponse(mascotaRepositoryOutPort.updateMascota(RequestMapper.toDomain(request), id));
    }
}
