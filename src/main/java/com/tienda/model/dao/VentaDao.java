package com.tienda.model.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.Venta;


public interface VentaDao extends JpaRepository<Venta, Integer>{
    
}
