package com.tienda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.ColorProducto;

public interface ColorProductoDao extends JpaRepository<ColorProducto, Integer> {
    
}
