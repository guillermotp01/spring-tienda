package com.tienda.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CrearUsuario(
        @NotBlank String nombre,
        @NotBlank @Pattern(regexp = "\\d{8}") String telefono) {
}
