package com.tienda.records.productos;

import com.tienda.model.Producto;
import com.tienda.model.Talla;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record ListarProductos(
        String nombre,
        String descripcion,
        Map<String,ListarTalla> tallas
) {
    public ListarProductos(Producto producto) {
        this(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getTallas()
                        .entrySet()
                        .stream()
                        .collect(Collectors
                                .toMap(Map
                                        .Entry::getKey,entry
                                        -> new ListarTalla(entry
                                        .getValue())))
        );
    }

}
