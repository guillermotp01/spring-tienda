package com.tienda.model.dto;

import java.io.Serializable;

import lombok.Builder;

@Builder
public class TallaProductoDto implements Serializable {
    private Integer idTallaProducto;
    private String talla;
    private int cantidad;

    public TallaProductoDto() {

    }

    public TallaProductoDto(Integer idTallaProducto, String talla, int cantidad) {
        this.idTallaProducto = idTallaProducto;
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public Integer getIdTallaProducto() {
        return idTallaProducto;
    }
    public String getTalla() {
        return talla;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setIdTallaProducto(Integer idTallaProducto) {
        this.idTallaProducto = idTallaProducto;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "TallaProductoDto [idTallaProducto=" + idTallaProducto + ", talla=" + talla + ", cantidad=" + cantidad + "]";
    }

}
