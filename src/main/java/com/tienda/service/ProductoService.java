package com.tienda.service;

import com.tienda.model.Producto;
import com.tienda.records.productos.CrearProducto;
import com.tienda.records.productos.ListarProductos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;

public interface ProductoService {

    Page<ListarProductos> listarProductos(@PageableDefault(size = 10) Pageable pageable);

    void registroProducto(CrearProducto producto);

    Producto buscarProductoPorNombre();



}
