package com.tienda.model;


import com.tienda.records.CrearUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
@ToString
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(length = 100,nullable = false)
    private String nombre;
    @Column(length = 9,nullable = false,unique = true)
    private String telefono;

    public Usuario(CrearUsuario datos) {
        this.nombre = datos.nombre();
        this.telefono = datos.telefono();
    }
}
