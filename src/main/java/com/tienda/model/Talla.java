package com.tienda.model;

import com.tienda.records.productos.CrearExistenciaProducto;
import com.tienda.records.productos.CrearTalla;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "talla")
@Entity
@Table(name = "tb_talla")
public class Talla  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id_talla")
    private long idTalla;

    @Column(nullable = false, length = 100,name = "talla")
    private  String talla;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @OneToMany(mappedBy = "talla",cascade = CascadeType.ALL)
    @MapKeyColumn(name = "nombre_color")
    private Map<String,ExistenciaProducto> existenciaProductoMap;

    public Talla(CrearTalla datos,Producto producto){
        this.talla = datos.talla();
        this.producto = producto;
        this.existenciaProductoMap = new HashMap<>();

        for (Map.Entry<String,CrearExistenciaProducto> elemento: datos.existenciasDisponibles().entrySet()) {
            this.existenciaProductoMap.put(
                    elemento.getKey(),
                    new ExistenciaProducto(elemento.getValue(),
                    this)
            );
        }
    }

}
