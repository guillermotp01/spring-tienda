package com.tienda.model.dto;


import java.io.Serializable;
import lombok.Builder;
@Builder


public class UsuarioDto implements Serializable {
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String password;

    public UsuarioDto() {

    }
    public UsuarioDto(Integer idUsuario, String nombre, String correo, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getPassword() {
        return password;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UsuarioDto [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", password="
                + password + "]";
    }
}
