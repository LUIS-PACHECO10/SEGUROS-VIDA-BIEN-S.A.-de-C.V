package com.mso.consulta.seguros.v1.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SEGURO")
@Getter
@Setter
public class Seguro {

    @Id
    @Column(name = "ID_SEGURO")
    private Integer idSeguro; // 1 = VIDA, 2 = INFARTO, 3 = MUJER

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "BENEFICIOS")
    private String beneficios;

    @Column(name = "COSTO_ANUAL")
    private Double costoAnual;

    @Column(name = "EDAD_MINIMA")
    private Integer edadMinima;

    @Column(name = "EDAD_MAXIMA")
    private Integer edadMaxima;

    @Column(name = "REQUIERE_GENERO_MUJER")
    private Boolean requiereGeneroMujer;
}
