package com.mso.validaciones.v1.dto;

import lombok.Data;

@Data
public class ValidacionRequestDto {
    private Integer idSeguro;
    private ClienteDto cliente;
}
