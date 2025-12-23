package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.adapter;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.out.MascotaRepositoryOutPort;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.model.Mascota;
import com.futuro_digital.demo.Clinica_Veterinaria.Domain.service.DomainServiceValidator;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.mapper.EntityMapper;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.repository.SpringDataDuenioRepository;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.repository.SpringDataMascotaRepository;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.BiPredicate;

/**
 * Adaptador de BBDD que implementa el puerto de salida: "OutPort"
 * Parsea modelo de dominio a entity para BBDD (PostgreSQL)
 * return modelo de dominio
 */
@Repository
@RequiredArgsConstructor
public class MascotaJpaRepositoryAdapter implements MascotaRepositoryOutPort {

    /**
     * Dependencias:
     * Implementar puerto de salida: "OutPort" con los repositorios: SpringDataJpa (BBDD)
     */
    private final SpringDataMascotaRepository springDataMascotaRepository;
    private final SpringDataDuenioRepository springDataDuenioRepository;

    /**
     * Auxiliares:
     * (limpieza y filtro de datos)
     */
    private final BiPredicate<Mascota, String> filterByEspecie = (m,especie) -> m.especie().equalsIgnoreCase(especie.strip());
    private final BiPredicate<Mascota, String> filterByRaza = (m,raza) -> m.raza().equalsIgnoreCase(raza.strip());

    @Override
    @Transactional
    public Mascota createMascota(Mascota mascota, Long idDuenio) {
        if(!DomainServiceValidator.isMascotaValid(mascota) || idDuenio == null) throw new RuntimeException("No deben haber campos Nulos o Vacios en el body (Mascota) o ID (Dueño)");
        var duenio = springDataDuenioRepository.findById(idDuenio).orElseThrow(()->new EntityNotFoundException("Dueño con ID: "+idDuenio+" no encontrado..."));
        var entityMascota = EntityMapper.toEntity(mascota);
        entityMascota.setDuenio(duenio);
        return EntityMapper.toDomain(springDataMascotaRepository.save(entityMascota));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascota> getAllMascotas() {
        return EntityMapper.mascotasListMapperToDomain(springDataMascotaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MascoDuenioResponse> getListOfMascoDuenios() {
        return EntityMapper.mapMascoDueniosList(springDataMascotaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota findByDuenio(Long idDuenio) {
        if(idDuenio == null) throw new RuntimeException("ID para Dueño Vacio!");
        return EntityMapper.toDomain(springDataMascotaRepository.findByDuenio_IdDuenio(idDuenio)
                .orElseThrow(()->new EntityNotFoundException("Dueño con ID: "+idDuenio+" no encontrado...")));
    }

    @Override
    public List<Mascota> filterByEspecie(String especie) {
        if(especie == null || especie.isEmpty())  throw new RuntimeException("Argumento para (Especie) Vacio!");
        return this.getAllMascotas().stream().filter(m->filterByEspecie.test(m,especie)).toList();
    }

    @Override
    public List<Mascota> filterByRaza(String raza) {
        if(raza == null || raza.isEmpty())  throw new RuntimeException("Argumento para (Raza) Vacio!");
        return this.getAllMascotas().stream().filter(m->filterByRaza.test(m,raza)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Mascota findMascota(Long id) {
        if(id == null) throw new RuntimeException("ID para Mascota Vacio!");
        return EntityMapper.toDomain( springDataMascotaRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("Mascota con ID: "+id+" no encontrada...")));
    }

    @Override
    @Transactional
    public Mascota updateMascota(Mascota mascota, Long id) {
        if(!DomainServiceValidator.isMascotaValid(mascota) || id == null) throw new RuntimeException("No deben haber campos Nulos o Vacios en el body (Mascota) o ID (Mascota)");

        var entity = springDataMascotaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Mascota con ID: "+id+" no encontrada..."));

        entity.setNombre(mascota.nombre());
        entity.setEspecie(mascota.especie());
        entity.setRaza(mascota.raza());
        entity.setColor(mascota.color());
        return EntityMapper.toDomain(springDataMascotaRepository.save(entity));
    }

    @Override
    @Transactional
    public void deleteMascota(Long id) {
        if(id == null || !springDataMascotaRepository.existsById(id)) throw new EntityNotFoundException("Mascota con ID: "+id+" no encontrada...");
        springDataMascotaRepository.deleteById(id);
    }
}
