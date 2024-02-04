package com.tienda.records.productos;

import com.tienda.model.ExistenciaProducto;

import java.math.BigDecimal;

public record ListarExistenciaProducto(
        String nombreColor,
        Integer cantidad,
        BigDecimal precioUnitario
) {
    public ListarExistenciaProducto(ExistenciaProducto datos){
        this(
                datos.getNombreColor(),
                datos.getCantidad(),
                datos.getPrecioUnitario()
        );
    }
}
