package com.tienda.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
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
}
