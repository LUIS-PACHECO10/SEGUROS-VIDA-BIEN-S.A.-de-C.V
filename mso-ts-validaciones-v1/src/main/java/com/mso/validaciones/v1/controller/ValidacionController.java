package com.mso.validaciones.v1.controller;

import com.mso.validaciones.v1.dto.ValidacionRequestDto;
import com.mso.validaciones.v1.dto.ValidacionResponseDto;
import com.mso.validaciones.v1.service.ValidacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validaciones")
public class ValidacionController {

    private final ValidacionService validacionService;

    public ValidacionController(ValidacionService validacionService) {
        this.validacionService = validacionService;
    }

    @PostMapping
    public ResponseEntity<ValidacionResponseDto> validar(@RequestBody ValidacionRequestDto request) {
        ValidacionResponseDto respuesta = validacionService.validarSolicitud(request);

        HttpStatus status = "201".equals(respuesta.getCodigo())
                ? HttpStatus.CREATED
                : HttpStatus.UNAUTHORIZED;

        return new ResponseEntity<>(respuesta, status);
    }
}
