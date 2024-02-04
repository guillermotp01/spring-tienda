package com.tienda.model;

import com.tienda.records.productos.CrearExistenciaProducto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_existencia_producto")
@EqualsAndHashCode(of = {"talla", "nombre_color"})
public class ExistenciaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false, length = 100,name = "nombre_color")
    private String nombreColor;

    @Column(nullable = false,name = "cantidad")
    private Integer cantidad;

    @Column(nullable = false,name = "precio_unitario")
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "idTalla")
    private Talla talla;


    public ExistenciaProducto(CrearExistenciaProducto data,Talla talla){
        this.talla = talla;
        this.nombreColor = data.nombreColor();
        this.cantidad = data.cantidad();
        this.precioUnitario = data.precioUnitario();
    }
}
