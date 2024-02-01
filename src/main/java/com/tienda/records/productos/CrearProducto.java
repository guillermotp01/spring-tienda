package com.tienda.records.productos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

public record CrearProducto(
        @NotBlank String nombre,
        @NotBlank String descripcion,
        @NotNull Map<String, CrearExistenciaProducto> existenciasDisponibles) {
}
