package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.repository;

import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.entity.DuenioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio:
 * interfaz conectada a BBDD con SpringDataJpa
 */
public interface SpringDataDuenioRepository extends JpaRepository<DuenioEntity,Long> {

    Optional<DuenioEntity> findByEmailIgnoreCase(String email);
}
