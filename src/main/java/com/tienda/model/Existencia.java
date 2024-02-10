package com.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tienda.DTO.crearDTO.CrearColorDTO;
import com.tienda.DTO.crearDTO.CrearExistenciaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_existencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEsxistencia")
public class Existencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idEsxistencia;

    @Column(length = 20,nullable = false)
    private String talla;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @OneToMany(mappedBy = "existencia",cascade = CascadeType.ALL)
    @MapKeyColumn(name = "color")
    Map<String,Color> color;
    public Existencia(String keyValue, CrearExistenciaDTO value, Producto producto) {
        this.talla = keyValue;
        this.producto = producto;
        this.color = new HashMap<>();
        StringBuilder key = new StringBuilder("");

        for (Map.Entry<String, CrearColorDTO> elemento: value.colores().entrySet()) {
            key.append(elemento.getKey());
            color.put(key.toString(),new Color(key.toString(),elemento.getValue(),this));
            key.setLength(0);
         }

    }
}
