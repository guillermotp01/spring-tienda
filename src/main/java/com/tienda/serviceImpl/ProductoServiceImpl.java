package com.tienda.serviceImpl;

import com.tienda.model.Producto;
import com.tienda.records.productos.CrearProducto;
import com.tienda.records.productos.ListarProductos;
import com.tienda.repositoris.ProductoRepository;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;


@Service
public class ProductoServiceImpl implements ProductoService {


    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    public Page<ListarProductos> listarProductos(@PageableDefault(size = 10) Pageable pageable) {
        return productoRepository.findAll(pageable).map(ListarProductos::new);
    }

    //guardado simple, sin verificaciones, pruebas
    @Override
    public void registroProducto(CrearProducto producto) {
        this.productoRepository.save(new Producto(producto));
    }

    @Override
    public Producto buscarProductoPorNombre() {
        return null;
    }


}
