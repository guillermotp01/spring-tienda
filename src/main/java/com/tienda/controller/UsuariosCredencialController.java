package com.tienda.controller;

import com.tienda.model.Credencial;
import com.tienda.records.CrearCredencial;
import com.tienda.repositoris.CredencialRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosCredencialController {

    @Autowired
    private CredencialRepository credencialRepository;

    @PostMapping("/crear-usuario-y-credencial")
    public void registrarUsuarioYCredencial(@Valid @RequestBody CrearCredencial datos){
        this.credencialRepository.save(new Credencial(datos));
    }
}
