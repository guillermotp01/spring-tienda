package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class TiendaController {
    
    @GetMapping("/principal")
    public String principal() {
        return "administrador/principal";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "administrador/usuarios";
    }

    @GetMapping("/inventario")
    public String inventario() {
        return "administrador/inventario";
    }

    @GetMapping("/agregar")
    public String agregar() {
        return "administrador/agregar";
    }

    @GetMapping("/venta")
    public String venta() {
        return "administrador/venta";
    }
    
    @GetMapping("/lista")
    public String lista() {
        return "administrador/lista";
    }
}
