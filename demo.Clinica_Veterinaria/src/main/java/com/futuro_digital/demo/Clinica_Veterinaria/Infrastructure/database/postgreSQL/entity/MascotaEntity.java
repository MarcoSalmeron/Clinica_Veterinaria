package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.database.postgreSQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad a persistir en BBDD (ORM)
 * (validando columnas)
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MASCOTAS")
public class MascotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String raza;

    @Column(nullable = false)
    private String color;

    /**
     * Relacion: 1:1
     * (1 Mascota por cada Dueño)
     */
    @OneToOne
    @JoinColumn(name = "id_duenio", referencedColumnName = "id_duenio")
    private DuenioEntity duenio;
}
