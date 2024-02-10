package com.tienda.model;


import com.tienda.DTO.crearDTO.CrearExistenciaDTO;
import com.tienda.DTO.crearDTO.CrearProductoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProducto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idProducto;

    @Column(name = "nombre_producto", length = 200, nullable = false)
    private String nombre;

    @Column(name = "descripcion_producto",length = 254,nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    @MapKeyColumn(name = "talla")
    private Map<String,Existencia> existencia;

    public Producto(CrearProductoDTO crearProductoDTO) {
        this.nombre = crearProductoDTO.nombre();
        this.descripcion = crearProductoDTO.descripcion();
        this.existencia = new HashMap<>();
        StringBuilder key = new StringBuilder("");

        for (Map.Entry<String, CrearExistenciaDTO> elemento:crearProductoDTO.existencia().entrySet()) {
            key.append(elemento.getKey());
            existencia.put(key.toString(), new Existencia(key.toString(),elemento.getValue(),this));
            key.setLength(0);
        }
    }

    public void actualizarDatos(CrearProductoDTO crearProductoDTO) {
        this.nombre = crearProductoDTO.nombre();
        this.descripcion = crearProductoDTO.descripcion();
        this.existencia = new HashMap<>();
        StringBuilder key = new StringBuilder("");

        for (Map.Entry<String, CrearExistenciaDTO> elemento:crearProductoDTO.existencia().entrySet()) {
            key.append(elemento.getKey());
            existencia.put(key.toString(), new Existencia(key.toString(),elemento.getValue(),this));
            key.setLength(0);
        }
    }
}
