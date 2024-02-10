package com.tienda.serviceInterface;


import com.tienda.DTO.crearDTO.CrearProductoDTO;
import com.tienda.DTO.listarDTO.ListarProductoDTO;
import com.tienda.excepciones.ProductoDuplicadoException;
import com.tienda.excepciones.ProductoNoExisteException;
import com.tienda.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface  ProductoInterface {

    Producto agregarProducto(CrearProductoDTO crearProductoDTO)throws ProductoDuplicadoException;
    Page<ListarProductoDTO> listarProductos(Pageable pagineable);

    Boolean buscarPorNombre(String nombre);

    Producto devolverProducto(String nombre) throws ProductoNoExisteException;

    Boolean eliminarProducto(String nombre) throws ProductoNoExisteException;

    Boolean actulizarProducto(CrearProductoDTO producto) throws ProductoNoExisteException;
}
