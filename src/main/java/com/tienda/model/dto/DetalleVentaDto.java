package com.tienda.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DetalleVentaDto {
    
    private Long idDetalleVenta;
    private Long idVenta;
    private Long idProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
