package com.tienda.DTO.usuarios;

import jakarta.validation.constraints.NotBlank;

public record CredencialLogin(
        @NotBlank String email,
        @NotBlank String password) {
}
