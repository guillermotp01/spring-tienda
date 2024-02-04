package com.tienda.records.productos;

import com.tienda.model.Producto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CrearExistenciaProducto(
        @NotBlank String nombreColor,
        @NotNull Integer cantidad,
        @NotBlank BigDecimal precioUnitario)
{




}