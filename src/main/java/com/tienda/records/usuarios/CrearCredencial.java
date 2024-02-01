package com.tienda.records.usuarios;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCredencial(
       @NotBlank @Email String email,
       @NotBlank String password,
       @NotNull @Valid CrearUsuario usuario) {

}
