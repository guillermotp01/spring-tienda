package com.tienda.service;

import java.util.List;

import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;



public interface IUsuarioService {

    List<Usuario> Listar();

    Usuario  Guardar(UsuarioDto  Usuario);

    Usuario  ListarId(Integer id);

    void Eliminar(Usuario  Usuario);
    
    boolean ExisteId(Integer id);
}
