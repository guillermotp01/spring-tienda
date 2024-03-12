package com.tienda.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto implements Serializable{

    private Integer idCliente;
    private String nombres;
    private String direccion;
    private String telefono;
    private String documento;
    private String tipoCliente;

    public ClienteDto() {
        
    }

    public ClienteDto(Integer idCliente, String nombres, String direccion, String telefono, String documento,
            String tipoCliente) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }  
}
