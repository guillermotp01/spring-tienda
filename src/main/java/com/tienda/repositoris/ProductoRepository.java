package com.tienda.repositoris;

import com.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query("SELECT MAX(P.idProducto) FROM Producto P")
    String devolverUltimoId();
}
