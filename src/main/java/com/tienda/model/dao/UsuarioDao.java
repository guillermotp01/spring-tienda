package com.tienda.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.model.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}
