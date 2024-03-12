package com.tienda.serviceInterface;

import org.springframework.data.domain.Page;

import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;



public interface IUsuarioService {

    public Page<Usuario> Listar(int page, int size);

    public Usuario Guardar(UsuarioDto  Usuario);

    public Usuario Actualizar(UsuarioDto Usuario, Integer id);

    public Usuario ListarId(Integer id);

    public void Eliminar(Usuario  Usuario);
    
    public boolean ExisteId(Integer id);
}
