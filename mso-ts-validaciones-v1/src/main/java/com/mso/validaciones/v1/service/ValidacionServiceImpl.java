package com.mso.validaciones.v1.service;

import com.mso.validaciones.v1.dto.ClienteDto;
import com.mso.validaciones.v1.dto.SeguroDto;
import com.mso.validaciones.v1.dto.ValidacionRequestDto;
import com.mso.validaciones.v1.dto.ValidacionResponseDto;
import com.mso.validaciones.v1.feign.SegurosClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ValidacionServiceImpl implements ValidacionService {

    private final SegurosClient segurosClient;

    public ValidacionServiceImpl(SegurosClient segurosClient) {
        this.segurosClient = segurosClient;
    }

    @Override
    public ValidacionResponseDto validarSolicitud(ValidacionRequestDto request) {
        ValidacionResponseDto response = new ValidacionResponseDto();

        // Seguro desde MS Consultas
        SeguroDto seguro = segurosClient.obtenerSeguroPorId(request.getIdSeguro());
        if (seguro == null) {
            response.setCodigo("401");
            response.setRespuesta("No se encontró información del seguro con id " + request.getIdSeguro());
            return response;
        }

        ClienteDto cliente = request.getCliente();
        String nombreCompleto = cliente.getNombre() + " " +
                cliente.getApellidoPaterno() + " " +
                cliente.getApellidoMaterno();

        //Calculamos edad
        Integer edad = calcularEdad(cliente.getFechaNacimiento());
        if (edad == null) {
            response.setCodigo("401");
            response.setRespuesta("La fecha de nacimiento proporcionada no es válida para el cliente " + nombreCompleto);
            return response;
        }

        // Validamos el rando de edad
        boolean fueraDeRango =
                (seguro.getEdadMinima() != null && edad < seguro.getEdadMinima()) ||
                        (seguro.getEdadMaxima() != null && edad > seguro.getEdadMaxima());

        if (fueraDeRango) {
            response.setCodigo("401");
            response.setRespuesta("Lo sentimos " + nombreCompleto +
                    ", no cumples con la edad requerida para contratar el seguro " +
                    seguro.getNombre());
            return response;
        }

        // Valdiamos género del aseugrado 1 hombe , 2 mujer
        if (Boolean.TRUE.equals(seguro.getRequiereGeneroMujer())) {
            if (cliente.getIdGenero() == null || cliente.getIdGenero() != 2) {
                response.setCodigo("401");
                response.setRespuesta("Lo sentimos " + nombreCompleto +
                        ", este seguro aplica únicamente para mujeres: " +
                        seguro.getNombre());
                return response;
            }
        }

        response.setCodigo("201");
        response.setRespuesta("¡Felicidades " + nombreCompleto +
                "! Cumples con las condiciones para contratar el seguro " +
                seguro.getNombre() + ".");
        return response;
    }

    //Calculamos la edad a partir de la fecha de nacimiento
    private Integer calcularEdad(String fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isBlank()) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
            return Period.between(fechaNac, LocalDate.now()).getYears();
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
