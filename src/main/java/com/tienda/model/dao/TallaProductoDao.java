package com.tienda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.TallaProducto;

public interface TallaProductoDao extends JpaRepository<TallaProducto, Integer> {
    
}