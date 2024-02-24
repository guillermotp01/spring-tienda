package com.tienda.DTO.listarDTO;

import java.util.Map;
import java.util.stream.Collectors;

import com.tienda.model.entity.Producto;

public record ListarProductoDTO(
        String nombre,
        String descripcion,
        Map<String, ListarExistenciaDTO> existencia) {
    public ListarProductoDTO(Producto producto){
        this(producto.getNombre(), producto.getDescripcion(), producto.getExistencia()
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map
                                .Entry::getKey,entry -> new ListarExistenciaDTO(entry
                                .getValue()))));
    }
}
