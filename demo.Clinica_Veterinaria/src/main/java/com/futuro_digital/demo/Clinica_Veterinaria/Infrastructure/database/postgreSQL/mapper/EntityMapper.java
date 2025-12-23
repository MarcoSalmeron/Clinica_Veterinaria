package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.mapper;

import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Duenio;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Mascota;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.entity.DuenioEntity;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.entity.MascotaEntity;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity-Mapper:
 * Parseo bidireccional: modelo de dominio a entity
 * return modelo de dominio o entity
 */
public class EntityMapper {

    // Domain -> Entity: build sin id
    public static DuenioEntity toEntity(Duenio domainDuenio){
        return DuenioEntity.builder()
                .dni(domainDuenio.dni())
                .nombre(domainDuenio.nombre())
                .apellido(domainDuenio.apellido())
                .telefono(domainDuenio.telefono())
                .email(domainDuenio.email())
                .build();
    }

    // Entity -> Domain: construir con id
    public static Duenio toDomain(DuenioEntity entity){
        return new Duenio(entity.getIdDuenio(), entity.getDni(), entity.getNombre(), entity.getApellido(), entity.getTelefono(), entity.getEmail());
    }

    public static List<Duenio> dueniosListMapperToDomain(List<DuenioEntity> entities){
        return entities.stream().map(EntityMapper::toDomain).toList();
    }

    // Domain -> Entity: build sin id
    public static MascotaEntity toEntity(Mascota domainMascota){
        return MascotaEntity.builder()
                .nombre(domainMascota.nombre())
                .especie(domainMascota.especie())
                .raza(domainMascota.raza())
                .color(domainMascota.color())
                .build();
    }

    // Entity -> Domain: construir con id
    public static Mascota toDomain(MascotaEntity entity){
        return new Mascota(entity.getId(), entity.getNombre(), entity.getEspecie(), entity.getRaza(), entity.getColor());
    }

    public static List<Mascota> mascotasListMapperToDomain(List<MascotaEntity> entities){
        return entities.stream().map(EntityMapper::toDomain).toList();
    }

    // List: Entity -> DTO Response (Mascotas con sus Dueños)
    public static List<MascoDuenioResponse> mapMascoDueniosList(List<MascotaEntity> entities){
        List<MascoDuenioResponse> mascoDueniosList = new ArrayList<>();
        MascoDuenioResponse mascoDuenio;

        // mapear relacion de entidades Mascota -> Dueño
        for(MascotaEntity mascotaEntity : entities){
            mascoDuenio = new MascoDuenioResponse(
                    mascotaEntity.getNombre(), mascotaEntity.getEspecie(), mascotaEntity.getRaza(),
                    mascotaEntity.getDuenio().getNombre(), mascotaEntity.getDuenio().getApellido(), mascotaEntity.getDuenio().getTelefono());

            mascoDueniosList.add(mascoDuenio);
        }
        return mascoDueniosList;
    }
}
