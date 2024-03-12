package com.tienda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {
    
}
