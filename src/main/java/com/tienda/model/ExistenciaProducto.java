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
@Table(name = "existencia_producto")
@EqualsAndHashCode(of = {"producto", "nombreColor"})
public class ExistenciaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombreColor;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public ExistenciaProducto(CrearExistenciaProducto data){
        this.nombreColor = data.nombreColor();
        this.cantidad = data.cantidad();
        this.precioUnitario = data.precioUnitario();
    }
}
