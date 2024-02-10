package com.tienda.serviceImplementation;


import com.tienda.DTO.crearDTO.CrearProductoDTO;
import com.tienda.DTO.listarDTO.ListarProductoDTO;
import com.tienda.excepciones.ProductoDuplicadoException;
import com.tienda.excepciones.ProductoNoExisteException;
import com.tienda.model.Producto;
import com.tienda.repositorys.ProductoRepository;
import com.tienda.serviceInterface.ProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoInterface {

    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    @Override
    public Producto agregarProducto(CrearProductoDTO dato)throws ProductoDuplicadoException {
        if(buscarPorNombre(dato.nombre()))
            throw new ProductoDuplicadoException("Producto: "+dato.nombre()+ " ya existe!" );
        return  productoRepository.save(new Producto(dato));
    }

    @Override
    public Page<ListarProductoDTO> listarProductos(Pageable pagineable) {
        return productoRepository.findAll(pagineable).map(ListarProductoDTO::new);
    }

    @Override
    public Boolean buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre) != null;
    }
    @Override
    public Producto devolverProducto(String nombre) throws ProductoNoExisteException {
        if(buscarPorNombre(nombre))
            return this.productoRepository.findByNombre(nombre);
        throw new ProductoNoExisteException("El producto: "+ nombre +" no existe.");
    }

    @Override
    public Boolean eliminarProducto(String nombre) throws ProductoNoExisteException {
        if(buscarPorNombre(nombre) )
            return this.productoRepository.deleteByNombre(nombre) == 1;
        throw new ProductoNoExisteException("El producto: "+ nombre +" no existe.");
    }

    @Override
    public Boolean actulizarProducto(CrearProductoDTO productoDTO) throws ProductoNoExisteException  {
        String nombreProducto = productoDTO.nombre();
        if(buscarPorNombre(nombreProducto)){
            Producto producto = this.productoRepository.getReferenceByNombre(nombreProducto);
            producto.actualizarDatos(productoDTO);
            return true;
        }
        throw new ProductoNoExisteException("El producto: "+ productoDTO.nombre() +" no existe.");
    }
}
