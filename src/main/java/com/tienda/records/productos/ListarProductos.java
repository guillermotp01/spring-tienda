package com.tienda.records.productos;

import com.tienda.model.ExistenciaProducto;
import com.tienda.model.Producto;

import java.util.Map;

public record ListarProductos(
        String nombre,
        String descripcion,
        Map<String,ExistenciaProducto> existenciasDisponibles
) {
    public ListarProductos(Producto producto) {
        this(producto.getNombre(),producto.getDescripcion(),producto.getExistenciasDisponibles());
    }
}
