package com.tienda.model.dto;

import lombok.Data;

@Data
public class DtoAuthRespuesta {
    private String token;

    public DtoAuthRespuesta(String token) {
        this.token = token;
    }
}
