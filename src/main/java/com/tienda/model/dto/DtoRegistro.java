package com.tienda.model.dto;

import lombok.Data;

@Data
public class DtoRegistro {
    private String nombre;
    private String apellido;
    private String correo;
    private String username;
    private String password;
}
