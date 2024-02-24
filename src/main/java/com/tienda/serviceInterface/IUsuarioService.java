package com.tienda.serviceInterface;

import java.util.List;

import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;



public interface IUsuarioService {

    public List<Usuario> Listar();

    public Usuario Guardar(UsuarioDto  Usuario);

    public Usuario Actualizar(UsuarioDto Usuario, Integer id);

    public Usuario ListarId(Integer id);

    public void Eliminar(Usuario  Usuario);
    
    public boolean ExisteId(Integer id);
}
