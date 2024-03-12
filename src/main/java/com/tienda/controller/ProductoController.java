package com.tienda.controller;

import com.tienda.model.dto.ProductoDto;
import com.tienda.model.entity.Producto;
import com.tienda.model.payload.mensajeResponse;
import com.tienda.serviceInterface.IProductoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")

public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping("/listarProducto")
    public ResponseEntity<Page<ProductoDto>> list(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        var result = productoService.Listar(page, size);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/registrarProducto")
    public ResponseEntity<Producto> save(@RequestBody ProductoDto productoDto) {
        Producto productoSave = null;
        productoSave = productoService.Guardar(productoDto);
        if (productoSave != null) {
            mensajeResponse.builder()
                    .mensaje("Guardado Correctamente");
        }
        return new ResponseEntity<>(productoSave, HttpStatus.OK);
    }

    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto> update(@RequestBody ProductoDto productoDto, @PathVariable Integer id) {
        Producto productoUpdate = productoService.Actualizar(productoDto, id);

        if (productoUpdate != null) {
            mensajeResponse.builder()
                    .mensaje("Actualizado correctamente");
        }
        return new ResponseEntity<>(productoUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) { // ResponseEntity maneja todas las respuestas HTTP
        try {
            Producto productoDelete = productoService.ListarId(id);
            productoService.Eliminar(productoDelete);
            return new ResponseEntity<>(productoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDT) {
            return new ResponseEntity<>(
                    mensajeResponse.builder()
                            .mensaje(exDT.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
