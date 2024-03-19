package com.tienda.servicios;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.tienda.model.entity.Usuario;
import com.tienda.model.entity.UsuarioRol;


public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public Usuario Actualizar(Usuario Usuario, Long id);

    public Page<Usuario> Listar(int page, int size);

    public Usuario ListarId(Long id);

    public void Eliminar(Usuario  Usuario);

    public void eliminarUsuario(Long usuarioId);
}
