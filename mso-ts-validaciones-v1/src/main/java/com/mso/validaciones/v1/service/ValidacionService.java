package com.mso.validaciones.v1.service;

import com.mso.validaciones.v1.dto.ValidacionRequestDto;
import com.mso.validaciones.v1.dto.ValidacionResponseDto;

public interface ValidacionService {

    ValidacionResponseDto validarSolicitud(ValidacionRequestDto request);
}
