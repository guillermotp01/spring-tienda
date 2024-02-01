package com.tienda.records.productos;

import java.math.BigDecimal;

public record ListarExistenciaProducto(
        String nombreColor,
        Integer cantidad,
        BigDecimal precioUnitario
) {
    public ListarExistenciaProducto(ListarExistenciaProducto datos){
        this(datos.nombreColor(), datos.cantidad(), datos.precioUnitario());
    }
}
