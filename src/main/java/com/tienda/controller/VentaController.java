package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tienda.model.dto.VentaDto;
import com.tienda.model.entity.Venta;
import com.tienda.serviceInterface.IVentaService;

@RestController
@RequestMapping("/ventas")
@CrossOrigin("*")

public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/listarVentas")
    public ResponseEntity<List<VentaDto>> obtenerVentas() {
        List<VentaDto> ventas = ventaService.obtenerVenta();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Integer id) {
        Venta venta = ventaService.ListarId(id);
        return new ResponseEntity<>(venta, HttpStatus.OK);
    }

    @PostMapping("/registrarVenta")
    public ResponseEntity<Venta> guardarVenta(@RequestBody VentaDto ventaDto) {
        Venta nuevaVenta = ventaService.Guardar(ventaDto);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarVenta/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody VentaDto ventaDto) {
        Venta ventaActualizada = ventaService.Actualizar(ventaDto, id);
        return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        Venta venta = ventaService.ListarId(id);
        ventaService.Eliminar(venta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
