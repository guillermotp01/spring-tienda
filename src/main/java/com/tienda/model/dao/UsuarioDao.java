package com.tienda.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.tienda.model.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{

}
