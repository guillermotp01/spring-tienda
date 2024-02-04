package com.tienda.records.productos;

import com.tienda.model.ExistenciaProducto;
import com.tienda.model.Producto;
import com.tienda.model.Talla;

import java.util.Map;

public record ListarTalla(
        String talla,
        Producto producto,
        Map<String, ExistenciaProducto> existenciasDisponibles
) {
    public ListarTalla(Talla datos){
        this(   datos.getTalla(),
                datos.getProducto(),
                datos.getExistenciaProductoMap()
        );
    }

}
