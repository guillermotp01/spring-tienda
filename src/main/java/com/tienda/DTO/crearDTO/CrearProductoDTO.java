package com.tienda.DTO.crearDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record CrearProductoDTO(
        @NotBlank String nombre,
        @NotBlank String descripcion,
        @NotNull Map<String, CrearExistenciaDTO> existencia
    ) {
}
