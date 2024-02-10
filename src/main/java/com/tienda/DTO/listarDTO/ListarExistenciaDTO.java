package com.tienda.DTO.listarDTO;

import com.tienda.model.Existencia;

import java.util.Map;
import java.util.stream.Collectors;

public record ListarExistenciaDTO(
        Map<String, ListarColorDTO> colores
    ) {
    public ListarExistenciaDTO(Existencia existencia) {
        this(existencia.getColor() .entrySet()
                .stream()
                .collect(Collectors.toMap(Map
                        .Entry::getKey,entry -> new ListarColorDTO(entry
                        .getValue()))));
    }
}
