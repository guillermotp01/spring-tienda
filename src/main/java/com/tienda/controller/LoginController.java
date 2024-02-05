package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login/login";
    }

    /*@GetMapping
    public String login(@Valid @RequestBody Credencial credencial) {
        credencialRepository.findBy(credencial);
    }*/
}


