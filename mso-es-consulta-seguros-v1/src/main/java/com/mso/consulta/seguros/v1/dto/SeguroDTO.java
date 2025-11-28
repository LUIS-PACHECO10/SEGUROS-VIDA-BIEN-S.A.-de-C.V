package com.mso.consulta.seguros.v1.dto;

import lombok.Data;

@Data
public class SeguroDTO {

    private Integer idSeguro;
    private String nombre;
    private String descripcion;
    private String beneficios;
    private Double costoAnual;
    private Integer edadMinima;
    private Integer edadMaxima;
    private Boolean requiereGeneroMujer;
}
