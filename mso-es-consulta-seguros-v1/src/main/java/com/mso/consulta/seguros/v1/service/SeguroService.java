package com.mso.consulta.seguros.v1.service;

import com.mso.consulta.seguros.v1.dto.SeguroDTO;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    List<SeguroDTO> obtenerTodos();

    Optional<SeguroDTO> obtenerPorId(Integer idSeguro);
}
