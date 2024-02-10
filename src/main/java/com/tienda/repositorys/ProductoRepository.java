package com.tienda.repositorys;

import com.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Producto findByNombre(String nombre);
    Integer deleteByNombre(String nombre);
    Producto getReferenceByNombre(String nombreProducto);
}
