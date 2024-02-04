package com.tienda.records.productos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

public record CrearTalla(
        @NotBlank String talla,
        @NotNull Map<String, CrearExistenciaProducto> existenciasDisponibles) {
}
