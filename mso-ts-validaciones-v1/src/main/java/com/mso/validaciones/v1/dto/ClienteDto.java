package com.mso.validaciones.v1.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private Integer idGenero; // 1 = Hombre, 2 = Mujer
}
