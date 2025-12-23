package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.repository;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio:
 * interfaz conectada a BBDD con SpringDataJpa
 */
public interface SpringDataMascotaRepository extends JpaRepository<MascotaEntity,Long> {

    Optional<MascotaEntity> findByDuenio_IdDuenio(Long idDuenio);
}
