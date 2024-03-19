package com.tienda.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_tallas_productos")

public class TallaProducto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla_producto")
    private Integer idTallaProducto;

    @Column(name = "talla")
    private String talla;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_color")
    @JsonManagedReference
    private ColorProducto colorProducto;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @JsonManagedReference
    private Producto producto;

}