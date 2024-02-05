package com.tienda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.model.dao.UsuarioDao;
import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;
import com.tienda.service.IUsuarioService;



//se utiliza para construir una clase de servicio que se conecta a varios repositorios y agrupa su funcionalidad
@Service
public class UsuarioImplService implements IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional
    @Override
    public Usuario Guardar(UsuarioDto  usuarioDto) {
        Usuario usuario = Usuario.builder()
            .idUsuario(usuarioDto.getIdUsuario())
            .nombre(usuarioDto.getNombre())
            .correo(usuarioDto.getCorreo())
            .password(usuarioDto.getPassword())
            .build();
        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario ListarId(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void Eliminar(Usuario  usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public boolean ExisteId(Integer id) {
        return usuarioDao.existsById(id);
    }

    @Override
    public List<Usuario> Listar() {
        return (List<Usuario>)usuarioDao.findAll();
    }
}
