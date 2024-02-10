package com.tienda.model;


import com.tienda.DTO.crearDTO.CrearColorDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "tb_color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idColor")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idColor;

    @Column(nullable = false,length = 100)
    private String color;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "idEsxistencia")
    private Existencia existencia;

    public Color(String key, CrearColorDTO value, Existencia existencia) {
        this.color = key;
        this.cantidad = value.cantidad();
        this.precio = value.precio();
        this.existencia = existencia;
    }
}