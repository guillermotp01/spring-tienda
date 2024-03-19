package com.tienda.model.entity;

import lombok.Builder;
import lombok.Data;


import java.io.Serializable;

import jakarta.persistence.*;


@Data
@Builder
@Entity
@Table(name = "tb_detalle_venta")
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long idDetalleVenta;

    // Relación con venta
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    // Relación con producto
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "subtotal", nullable = false)
    private double subtotal;

}