package com.tienda.model.dto;


import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ProductoDto  implements Serializable{
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private List<ColorProductoDto> colores;
    
    public ProductoDto() {
        this.colores = new ArrayList<>();
    }
    
    public ProductoDto(Integer idProducto, String nombre, String descripcion, double precio, List<ColorProductoDto> colores) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.colores = colores;
    }
}