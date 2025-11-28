package com.mso.consulta.seguros.v1.service;

import com.mso.consulta.seguros.v1.dto.SeguroDTO;
import com.mso.consulta.seguros.v1.entity.Seguro;
import com.mso.consulta.seguros.v1.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeguroServiceImpl implements SeguroService {

    private final SeguroRepository seguroRepository;

    public SeguroServiceImpl(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }

    @Override
    public List<SeguroDTO> obtenerTodos() {
        return seguroRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SeguroDTO> obtenerPorId(Integer idSeguro) {
        return seguroRepository.findById(idSeguro)
                .map(this::mapToDto);
    }

    private SeguroDTO mapToDto(Seguro entity) {
        SeguroDTO dto = new SeguroDTO();
        dto.setIdSeguro(entity.getIdSeguro());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setBeneficios(entity.getBeneficios());
        dto.setCostoAnual(entity.getCostoAnual());
        dto.setEdadMinima(entity.getEdadMinima());
        dto.setEdadMaxima(entity.getEdadMaxima());
        dto.setRequiereGeneroMujer(entity.getRequiereGeneroMujer());
        return dto;
    }
}
