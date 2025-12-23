package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.mapper;

import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Duenio;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Mascota;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.*;

import java.util.List;

/**
 * Request-Mapper:
 * Parseo bidireccional: DTO Request a modelo de dominio
 * return DTO Response o modelo de dominio
 */
public class RequestMapper {

    // Domain -> Response: contruir con id
    public static DuenioResponse toResponse(Duenio domain){
        return new DuenioResponse(domain.id(), domain.dni(), domain.nombre(), domain.apellido(), domain.telefono(), domain.email());
    }

    // DTO Request -> Domain: build sin id
    public static Duenio toDomain(DuenioRequest request){
        return Duenio.builder()
                .dni(request.dni())
                .nombre(request.nombre())
                .apellido(request.apellido())
                .telefono(request.telefono())
                .email(request.email())
                .build();
    }

    public static List<DuenioResponse> duenioListMapperToReponse(List<Duenio> domain){
        return domain.stream().map(RequestMapper::toResponse).toList();
    }

    // Domain -> Response: contruir con id
    public static MascotaResponse toResponse(Mascota domain){
        return new MascotaResponse(domain.id(), domain.nombre(), domain.especie(), domain.raza(), domain.color());
    }

    // DTO Request -> Domain: build sin id
    public static Mascota toDomain(MascotaRequest request){
        return Mascota.builder()
                .nombre(request.nombre())
                .especie(request.especie())
                .raza(request.raza())
                .color(request.color())
                .build();
    }

    public static List<MascotaResponse> mascotaListMapperToResponse(List<Mascota> domain){
        return domain.stream().map(RequestMapper::toResponse).toList();
    }
}
