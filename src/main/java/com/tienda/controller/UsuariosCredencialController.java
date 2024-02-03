package com.tienda.controller;

import com.tienda.model.Credencial;
import com.tienda.records.usuarios.CrearCredencial;
import com.tienda.repositoris.CredencialRepository;
import com.tienda.service.CredencialService;
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
    private final CredencialService credencialService;
    @Autowired
    public UsuariosCredencialController(CredencialService credencialService){
        this.credencialService = credencialService;
    }
    @PostMapping("/crear-usuario-y-credencial")
    public void registrarUsuarioYCredencial(@Valid @RequestBody CrearCredencial datos){
        this.credencialService.registrarUsuarioYCredencial(datos);
    }
}
