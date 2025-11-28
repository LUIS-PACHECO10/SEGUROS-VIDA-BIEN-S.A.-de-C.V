package com.mso.validaciones.v1.dto;

import lombok.Data;

@Data
public class SeguroDto {
    private Integer idSeguro;
    private String nombre;// "VIDA", "INFARTO", "MUJER"
    private String descripcion;
    private String beneficios;
    private Double costoAnual;

    private Integer edadMinima;
    private Integer edadMaxima;
    private Boolean requiereGeneroMujer;
}
