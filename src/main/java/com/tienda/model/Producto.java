package com.tienda.model;

import com.tienda.records.productos.CrearProducto;
import com.tienda.records.productos.CrearTalla;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	@Column(name = "id_producto")
	private String idProducto;

	@Column(length = 200,nullable = false)
	private String nombre;

	@Column(length = 254,nullable = false)
	private String descripcion;

	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
	private Map<String, Talla> tallas;

	public  Producto(CrearProducto datos){
		this.nombre = datos.nombre();
		this.descripcion = datos.descripcion();
		this.tallas = new HashMap<>();

		for (Map.Entry<String, CrearTalla> elemento: datos.tallas().entrySet()) {
			this.tallas.put(
					elemento.getKey(),
					new Talla(elemento.getValue(),
					this)
			);
		}
	}
}
