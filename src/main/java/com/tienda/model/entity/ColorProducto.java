package com.tienda.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_colores")
public class ColorProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color")
    private Integer idColor;

    @Column(name = "nombre_color", length = 20, nullable = false)
    private String nombre;

    // Relación muchos a uno con Producto
    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonManagedReference
    private Producto producto;

    @OneToMany(mappedBy = "colorProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("colorProducto") // Opcional, si estás utilizando Jackson
    private List<TallaProducto> tallas;
}