package com.tienda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {
    
}
