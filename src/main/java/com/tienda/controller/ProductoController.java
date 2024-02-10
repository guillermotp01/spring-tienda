package com.tienda.controller;


import com.tienda.DTO.crearDTO.CrearProductoDTO;
import com.tienda.DTO.listarDTO.ListarProductoDTO;
import com.tienda.excepciones.ProductoDuplicadoException;
import com.tienda.excepciones.ProductoNoExisteException;
import com.tienda.serviceInterface.ProductoInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoInterface productoInterface;
    @Autowired
    public ProductoController(ProductoInterface productoInterface){
        this.productoInterface = productoInterface;
    }
    @PostMapping("/registrar-producto")
    public ResponseEntity<ListarProductoDTO> registrarProducto(@Valid @RequestBody CrearProductoDTO dato) throws ProductoDuplicadoException {
        return ResponseEntity.ok(new ListarProductoDTO(this.productoInterface.agregarProducto(dato)));
    }
    @GetMapping("/listar-producto")
    public ResponseEntity<Page<ListarProductoDTO>> listarProductos(Pageable pageable){
        return ResponseEntity.ok(productoInterface.listarProductos(pageable));
    }
    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<ListarProductoDTO> devolverProducto(@PathVariable String nombre)throws ProductoNoExisteException {
        return ResponseEntity.ok(new ListarProductoDTO(productoInterface.devolverProducto(nombre)));
    }
    @DeleteMapping("/eliminar-por-nombre/{nombre}")
    @Transactional
    public ResponseEntity<?> eliminarProducto(@PathVariable String nombre)throws ProductoNoExisteException{
        return ResponseEntity.ok(productoInterface.eliminarProducto(nombre));
    }

    @PutMapping("/actualizar-por-nombre")
    @Transactional
    public ResponseEntity<?> actulizarProducto(@Valid @RequestBody CrearProductoDTO crearProductoDTO)throws ProductoNoExisteException{
        return ResponseEntity.ok(productoInterface.actulizarProducto(crearProductoDTO));
    }

}
