package com.tienda.serviceInterface.impl;

import com.tienda.model.dao.ProductoDao;
import com.tienda.model.dto.ColorProductoDto;
import com.tienda.model.dto.ProductoDto;
import com.tienda.model.dto.TallaProductoDto;
import com.tienda.model.entity.ColorProducto;
import com.tienda.model.entity.Producto;
import com.tienda.model.entity.TallaProducto;
import com.tienda.serviceInterface.IProductoService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Producto Guardar(ProductoDto productoDto) {
        // Convertir la lista de DTOs de colores a una lista de entidades ColorProducto
        List<ColorProducto> colores = productoDto.getColores().stream()
                .map((ColorProductoDto colorDto) -> {
                    // Convertir la lista de DTOs de tallas a una lista de entidades TallaProducto
                    List<TallaProducto> tallas = colorDto.getTallas().stream()
                            .map((TallaProductoDto tallaDto) -> TallaProducto.builder()
                                    .talla(tallaDto.getTalla())
                                    .cantidad(tallaDto.getCantidad())
                                    .colorProducto(null) // La relación se establecerá más adelante
                                    .build())
                            .collect(Collectors.toList());

                    // Crear la entidad ColorProducto con las tallas
                    ColorProducto colorProducto = ColorProducto.builder()
                            .nombre(colorDto.getNombre())
                            .tallas(tallas)
                            .producto(null) // La relación se establecerá más adelante
                            .build();

                    // Establecer la relación bidireccional
                    for (TallaProducto talla : tallas) {
                        talla.setColorProducto(colorProducto);
                    }

                    return colorProducto;
                })
                .collect(Collectors.toList());

        // Crear la entidad Producto con los colores
        Producto producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .descripcion(productoDto.getDescripcion())
                .precio(productoDto.getPrecio())
                .colores(colores)
                .build();

        // Establecer la relación bidireccional
        for (ColorProducto color : colores) {
            color.setProducto(producto);
        }

        // Guardar en la base de datos
        Producto productoGuardado = productoDao.save(producto);

        // Establecer la relación bidireccional restante
        for (ColorProducto color : colores) {
            for (TallaProducto talla : color.getTallas()) {
                talla.setColorProducto(color);
                talla.setProducto(productoGuardado);
            }
        }

        return productoGuardado;
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Producto Actualizar(ProductoDto productoDto, Integer id) {
        Optional<Producto> productoOptional = productoDao.findById(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoDto.getNombre());
            producto.setDescripcion(productoDto.getDescripcion());
            producto.setPrecio(productoDto.getPrecio());

            List<ColorProducto> colores = productoDto.getColores().stream()
                    .map(colorDto -> {
                        ColorProducto color = producto.getColores().stream()
                                .filter(c -> c.getIdColor().equals(colorDto.getIdColor()))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("Color no encontrado"));

                        color.setNombre(colorDto.getNombre());

                        List<TallaProducto> tallas = colorDto.getTallas().stream()
                                .map(tallaDto -> {
                                    TallaProducto talla = color.getTallas().stream()
                                            .filter(t -> t.getIdTallaProducto().equals(tallaDto.getIdTallaProducto()))
                                            .findFirst()
                                            .orElse(new TallaProducto());

                                    talla.setTalla(tallaDto.getTalla());
                                    talla.setCantidad(tallaDto.getCantidad());
                                    talla.setColorProducto(color);
                                    talla.setProducto(producto);

                                    return talla;
                                })
                                .collect(Collectors.toList());

                        color.getTallas().clear();
                        color.getTallas().addAll(tallas);

                        return color;
                    })
                    .collect(Collectors.toList());

            producto.getColores().clear();
            producto.getColores().addAll(colores);

            return productoDao.save(producto);
        } else {
            return null;
        }
    }


    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    @Override
    public Producto ListarId(Integer id) {
        return productoDao.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public void Eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @SuppressWarnings("null")
    @Override
    public boolean ExisteId(Integer id) {
        return productoDao.existsById(id);
    }

    @Override
    public List<Producto> Listar() {
        return (List<Producto>) productoDao.findAll();
    }

    // creando un metodo para unir el dto de producto y el dto de talla, para que me
    // pueda mostrar el producto junto a sus tallas
    @Override
    public List<ProductoDto> obtenerProductos() {
        List<Producto> productos = productoDao.findAll();
        return convertirAProductoDto(productos);
    }

    // Crear un nuevo método para convertir ColorProducto a DTO
    private ColorProductoDto convertirAColorProductoDto(ColorProducto color) {
        return ColorProductoDto.builder()
                .idColor(color.getIdColor())
                .nombre(color.getNombre())
                .tallas(convertirATallaProductoDto(color.getTallas()))
                .build();
    }

    // Actualizar el método convertirAProductoDto para utilizar el nuevo método
    private List<ProductoDto> convertirAProductoDto(List<Producto> productos) {
        return productos.stream()
                .map(producto -> ProductoDto.builder()
                        .idProducto(producto.getIdProducto())
                        .nombre(producto.getNombre())
                        .descripcion(producto.getDescripcion())
                        .precio(producto.getPrecio())
                        .colores(producto.getColores().stream()
                                .map(this::convertirAColorProductoDto)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    // convertir talla a dto
    private List<TallaProductoDto> convertirATallaProductoDto(List<TallaProducto> tallas) {
        return tallas.stream()
                .map(talla -> TallaProductoDto.builder()
                        .idTallaProducto(talla.getIdTallaProducto())
                        .talla(talla.getTalla())
                        .cantidad(talla.getCantidad())
                        .build())
                .collect(Collectors.toList());
    }
}
