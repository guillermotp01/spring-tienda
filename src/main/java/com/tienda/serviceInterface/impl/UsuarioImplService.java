package com.tienda.serviceInterface.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.model.dao.UsuarioDao;
import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;
import com.tienda.serviceInterface.IUsuarioService;


@Service
public class UsuarioImplService implements IUsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;

    @SuppressWarnings("null")
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

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Usuario Actualizar(UsuarioDto usuarioDto, Integer id) {
        Optional<Usuario> usuarioOptional = usuarioDao.findById(id);
    
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setCorreo(usuarioDto.getCorreo());
            usuario.setPassword(usuarioDto.getPassword());
            return usuarioDao.save(usuario);
        } else {
            return null;
        }
    }
    
    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    @Override
    public Usuario ListarId(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public void Eliminar(Usuario  usuario) {
        usuarioDao.delete(usuario);
    }

    @SuppressWarnings("null")
    @Override
    public boolean ExisteId(Integer id) {
        return usuarioDao.existsById(id);
    }

    @Override
    public List<Usuario> Listar() {
        return (List<Usuario>)usuarioDao.findAll();
    }
}
