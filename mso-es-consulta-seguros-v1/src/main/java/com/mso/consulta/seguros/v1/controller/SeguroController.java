package com.mso.consulta.seguros.v1.controller;

import com.mso.consulta.seguros.v1.dto.SeguroDTO;
import com.mso.consulta.seguros.v1.service.SeguroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    private final SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @GetMapping
    public ResponseEntity<?> obtenerSeguros(
            @RequestParam(value = "idSeguro", required = false) Integer idSeguro) {

        if (idSeguro == null) {
            List<SeguroDTO> seguros = seguroService.obtenerTodos();
            Map<String, Object> body = new HashMap<>();
            body.put("seguros", seguros);
            return ResponseEntity.ok(body);
        }

        if (idSeguro <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El Id del seguro es inválido");
        }

        return seguroService.obtenerPorId(idSeguro)
                .<ResponseEntity<?>>map(seguro -> {
                    Map<String, Object> body = new HashMap<>();
                    body.put("seguros", Collections.singletonList(seguro));
                    return ResponseEntity.ok(body);
                })
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se encontró información del idSeguro " + idSeguro));
    }

    @GetMapping("/{idSeguro}")
    public ResponseEntity<?> obtenerSeguroPorId(@PathVariable Integer idSeguro) {
        if (idSeguro == null || idSeguro <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El Id del seguro es inválido");
        }

        return seguroService.obtenerPorId(idSeguro)
                .<ResponseEntity<?>>map(seguro -> ResponseEntity.ok(seguro))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se encontró información del idSeguro " + idSeguro));
    }
}
