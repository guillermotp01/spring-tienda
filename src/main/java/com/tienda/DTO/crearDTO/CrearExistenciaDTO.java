package com.tienda.DTO.crearDTO;

import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record CrearExistenciaDTO(
        @NotNull Map<String, CrearColorDTO> colores
    ) {
}
