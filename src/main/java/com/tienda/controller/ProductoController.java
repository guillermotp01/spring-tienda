package com.tienda.controller;

import com.tienda.records.productos.CrearProducto;
import com.tienda.records.productos.ListarProductos;
import com.tienda.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public  ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/listarProductos")
    public String listarProductos() {
        return "/producto/listarProductos";
    }

    @GetMapping("/agregarProducto")
    public String agregarProductos() {
        return "/producto/agregarProducto";
    }
    
    @GetMapping("/listar-productos")
    public Page<ListarProductos> listarProductos(@PageableDefault(size = 10) Pageable pageable) {
        return this.productoService.listarProductos(pageable);
    }
    @PostMapping("/registrar-producto")
    @Transactional
    public void registrarProducto(@Valid @RequestBody CrearProducto producto){
        productoService.registroProducto(producto);
    }

}
