package com.tienda.records.productos;

import com.tienda.model.ExistenciaProducto;
import com.tienda.model.Producto;
import com.tienda.model.Talla;

import java.util.Map;
import java.util.stream.Collectors;

public record ListarTalla(
        String talla,
        Producto producto,
        Map<String, ListarExistenciaProducto> existenciasDisponibles
) {
    public ListarTalla(Talla datos){
        this(   datos.getTalla(),
                datos.getProducto(),
                datos.getExistenciaProductoMap().entrySet()
                        .stream()
                        .collect(Collectors
                                .toMap(Map
                                        .Entry::getKey,entry
                                        -> new ListarExistenciaProducto(entry
                                        .getValue())))
        );
    }

}
