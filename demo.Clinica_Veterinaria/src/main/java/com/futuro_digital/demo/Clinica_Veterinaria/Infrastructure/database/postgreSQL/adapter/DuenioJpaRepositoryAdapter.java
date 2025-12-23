package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.adapter;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out.DuenioRepositoryOutPort;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Duenio;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.service.DomainServiceValidator;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.mapper.EntityMapper;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.repository.SpringDataDuenioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Adaptador de BBDD que implementa el puerto de salida: "OutPort"
 * Parsea modelo de dominio a entity para BBDD (PostgreSQL)
 * return modelo de dominio
 */
@Repository
@RequiredArgsConstructor
public class DuenioJpaRepositoryAdapter implements DuenioRepositoryOutPort {

    /**
     * Dependencia:
     * Implementar puerto de salida: "OutPort" con repositorio: SpringDataJpa (BBDD)
     */
    private final SpringDataDuenioRepository springDataDuenioRepository;

    @Override
    @Transactional
    public Duenio createDuenio(Duenio duenio) {
        if(!DomainServiceValidator.isDuenioValid(duenio)) throw new RuntimeException("No deben haber campos Nulos o Vacios en el body (Dueño)");
        return EntityMapper.toDomain(springDataDuenioRepository.save(EntityMapper.toEntity(duenio)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Duenio> getAllDuenios() {
        return EntityMapper.dueniosListMapperToDomain(springDataDuenioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Duenio findDuenio(Long id) {
        return EntityMapper.toDomain( springDataDuenioRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("Dueño con ID: "+id+" no encontrado...")));
    }

    @Override
    @Transactional(readOnly = true)
    public Duenio findDuenio(String email) {
        return EntityMapper.toDomain( springDataDuenioRepository
                .findByEmailIgnoreCase(email.strip())
                .orElseThrow(()->new EntityNotFoundException("Dueño con Email: "+email+" no encontrado...")));
    }

    @Override
    @Transactional
    public Duenio updateDuenio(Duenio duenio, Long id) {
        if(!DomainServiceValidator.isDuenioValid(duenio)) throw new RuntimeException("No deben haber campos Nulos o Vacios en el body");

        var entity = springDataDuenioRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Dueño con ID: "+id+" no encontrado..."));

        entity.setDni(duenio.dni());
        entity.setNombre(duenio.nombre());
        entity.setApellido(duenio.apellido());
        entity.setTelefono(duenio.telefono());
        entity.setEmail(duenio.email());

        return EntityMapper.toDomain(springDataDuenioRepository.save(entity));
    }

    @Override
    @Transactional
    public void deleteDuenio(Long id) {
        if(!springDataDuenioRepository.existsById(id)) throw new EntityNotFoundException("Dueño con ID: "+id+" no encontrado...");
        springDataDuenioRepository.deleteById(id);
    }
}
