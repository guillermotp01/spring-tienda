package com.tienda.model.dto;


import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import lombok.Builder;
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

    public Integer getIdProducto() {
        return idProducto;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Double getPrecio() {
        return precio;
    }
    public List<ColorProductoDto> getColores() {
        return colores;
    }
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setColores(List<ColorProductoDto> colores) {
        this.colores = colores;
    }

    @Override
    public String toString() {
        return "ProductoDto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", precio=" + precio + ", colores=" + colores + "]";
    }
}