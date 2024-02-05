package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venta")
public class VentaController {
    
    @GetMapping("/realizarVenta")
    public String realizarVenta() {
        return "venta/realizarVenta";
    }

    @GetMapping("/listarVentas")
    public String login() {
        return "venta/listarVentas";
    }

}
