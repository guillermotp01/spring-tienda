package com.tienda.serviceInterface;

import com.tienda.model.dto.ProductoDto;
import com.tienda.model.entity.Producto;


import java.util.List;

public interface IProductoService {

    public List<ProductoDto> obtenerProductos();
    
    public List<Producto> Listar();

    public Producto Guardar(ProductoDto productoDto);

    public Producto Actualizar(ProductoDto productoDto, Integer idProducto);

    public Producto ListarId(Integer id);

    public void Eliminar(Producto producto);

    public boolean ExisteId(Integer idProducto);

}