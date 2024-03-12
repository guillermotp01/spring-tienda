package com.tienda.serviceInterface;

import com.tienda.model.dto.ProductoDto;
import com.tienda.model.entity.Producto;

import org.springframework.data.domain.Page;

public interface IProductoService {
    
    public Page<ProductoDto> Listar(int page, int size);

    public Producto Guardar(ProductoDto productoDto);

    public Producto Actualizar(ProductoDto productoDto, Integer idProducto);

    public Producto ListarId(Integer id);

    public void Eliminar(Producto producto);

    public boolean ExisteId(Integer idProducto);

}