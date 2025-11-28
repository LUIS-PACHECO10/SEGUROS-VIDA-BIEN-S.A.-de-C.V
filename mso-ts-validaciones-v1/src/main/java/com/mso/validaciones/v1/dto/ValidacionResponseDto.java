package com.mso.validaciones.v1.dto;

import lombok.Data;

@Data
public class ValidacionResponseDto {
    private String codigo;// 201 o 401
    private String respuesta;// mensaje nombre seguro y cliente
}
