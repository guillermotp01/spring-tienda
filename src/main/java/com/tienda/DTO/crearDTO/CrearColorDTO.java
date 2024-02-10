package com.tienda.DTO.crearDTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CrearColorDTO(
        @NotNull Integer cantidad,
        @NotNull BigDecimal precio) {
}
