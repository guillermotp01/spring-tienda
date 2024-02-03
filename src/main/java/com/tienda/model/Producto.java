package com.tienda.model;

import com.tienda.records.productos.CrearExistenciaProducto;
import com.tienda.records.productos.CrearProducto;
import com.tienda.serviceImpl.ProductoServiceImpl;
import com.tienda.utils.GenerarId;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProducto")
@ToString
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idProducto;

	@Column(length = 200,nullable = false)
	private String nombre;

	@Column(length = 254,nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	@MapKeyColumn(name = "nombreColor")
	private Map<String, ExistenciaProducto> existenciasDisponibles;

	public  Producto(CrearProducto datos){
		this.nombre = datos.nombre();
		this.descripcion = datos.descripcion();
		this.existenciasDisponibles = new HashMap<>();

		for (Map.Entry<String, CrearExistenciaProducto> lista: datos.existenciasDisponibles().entrySet()) {
			String talla = lista.getKey();
			CrearExistenciaProducto crearExistenciaProducto = lista.getValue();
			ExistenciaProducto existenciaProducto = new ExistenciaProducto(crearExistenciaProducto,this);
			existenciasDisponibles.put(talla,existenciaProducto);
		}
	}

}
