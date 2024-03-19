package com.tienda.model.dto;

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
}