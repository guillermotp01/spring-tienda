package com.tienda.model.entity;

import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import jakarta.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tb_clientes")

public class Cliente implements Serializable {

    public enum TipoCliente {
        EMPRESA,
        PERSONA
    }

    public enum TipoDocumento{
        RUC,
        DNI,
        PASAPORTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombres", length = 40, nullable = false)
    private String nombres;

    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 12, nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", length = 10, nullable = false)
    private TipoDocumento tipoDocumento;  

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", length = 10, nullable = false)
    private TipoCliente tipoCliente;  // Puede ser "Empresa" o "Persona"
}
