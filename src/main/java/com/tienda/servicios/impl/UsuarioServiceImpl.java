package com.tienda.servicios.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tienda.model.entity.UsuarioRol;
import com.tienda.repositorios.RolRepository;
import com.tienda.repositorios.UsuarioRepository;
import com.tienda.model.entity.Usuario;
import com.tienda.servicios.UsuarioService;

import jakarta.transaction.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }


    @SuppressWarnings("null")
    @Transactional
    @Override
    public Usuario Actualizar(Usuario user, Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(user.getNombre());
            usuario.setApellido(user.getApellido());
            usuario.setTelefono(user.getTelefono());
            usuario.setEmail(user.getEmail());
            usuario.setPassword(user.getPassword());
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public Page<Usuario> Listar(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return usuarioRepository.findAll(pageRequest);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public Usuario ListarId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    @Transactional
    @Override
    public void Eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}