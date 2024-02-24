package com.tienda.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;

@Builder
public class ColorProductoDto implements Serializable {
    private Integer idColor;
    private String nombre;
    private List<TallaProductoDto> tallas; 

    public ColorProductoDto() {
        this.tallas = new ArrayList<>();
    }

    public ColorProductoDto(Integer idColor, String nombre, List<TallaProductoDto> tallas) {
        this.idColor = idColor;
        this.nombre = nombre;
        this.tallas = tallas;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TallaProductoDto> getTallas() {
        return tallas;
    }

    public void setTallas(List<TallaProductoDto> tallas) {
        this.tallas = tallas;
    }

    @Override
    public String toString() {
        return "ColorProductoDto [idColor=" + idColor + ", nombre=" + nombre + ", tallas=" + tallas + "]";
    }
}
