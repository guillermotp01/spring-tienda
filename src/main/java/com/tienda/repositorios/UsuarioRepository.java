package com.tienda.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Método para poder buscar un usuario mediante su nombre
    public Usuario findByUsername(String username);
}