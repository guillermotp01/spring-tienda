package com.tienda.records.productos;

import com.tienda.model.Producto;
import com.tienda.model.Talla;
import java.util.List;
import java.util.Map;

public record ListarProductos(
        String nombre,
        String descripcion,
        Map<String,Talla> tallas
) {
    public ListarProductos(Producto producto) {
        this(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getTallas()
        );
    }

}
