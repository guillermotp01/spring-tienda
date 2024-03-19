package com.tienda.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}