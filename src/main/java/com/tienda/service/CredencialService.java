package com.tienda.service;

import com.tienda.records.usuarios.CrearCredencial;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface CredencialService {
    public void registrarUsuarioYCredencial(CrearCredencial datos);
}
