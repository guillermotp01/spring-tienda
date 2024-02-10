package com.tienda.DTO.listarDTO;

import com.tienda.model.Color;

import java.math.BigDecimal;

public record ListarColorDTO(
        Integer cantidad,
        BigDecimal precio) {

    public ListarColorDTO(Color color) {
        this(color.getCantidad(),color.getPrecio());
    }

}
