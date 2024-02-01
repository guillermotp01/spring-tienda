package com.tienda.controller;

import com.tienda.model.Credencial;
import com.tienda.repositoris.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CredencialRepository credencialRepository;

    @GetMapping("/credencial/{email}")
    public void login(@PathVariable String email){
        Credencial credencial = credencialRepository.getReferenceByEmail(email);
    }

    /*@GetMapping
    public String login(@Valid @RequestBody Credencial credencial) {
        credencialRepository.findBy(credencial);
    }*/
}


