package com.tienda.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder

public class mensajeResponse implements Serializable{
    
    String mensaje;
    Object object;
}
