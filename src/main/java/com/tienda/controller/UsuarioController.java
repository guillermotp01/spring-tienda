package com.tienda.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.tienda.model.entity.Rol;
import com.tienda.model.entity.Usuario;
import com.tienda.model.entity.UsuarioRol;
import com.tienda.model.payload.mensajeResponse;
import com.tienda.servicios.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

        //@Autowired
        //private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Autowired
        private UsuarioService usuarioService;

        @PostMapping("/")
        public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
                usuario.setPerfil("default.png");

                //usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
                Set<UsuarioRol> usuarioRoles = new HashSet<>();

                Rol rol = new Rol();
                rol.setRolId(2L);
                rol.setRolNombre("NORMAL");

                UsuarioRol usuarioRol = new UsuarioRol();
                usuarioRol.setUsuario(usuario);
                usuarioRol.setRol(rol);

                usuarioRoles.add(usuarioRol);
                return usuarioService.guardarUsuario(usuario, usuarioRoles);
        }


        @GetMapping("/listarUsuarios")
        public ResponseEntity<Page<Usuario>> list(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "2") int size) {
                var result = usuarioService.Listar(page, size);
                return new ResponseEntity<>(result, HttpStatus.OK);
        }


        @PutMapping("/actualizarUsuario/{id}")
        public ResponseEntity<?> update(@RequestBody Usuario user, @PathVariable Long id) {
                Usuario usuarioUpdate = usuarioService.Actualizar(user, id);

                if (usuarioUpdate != null) {
                        mensajeResponse.builder()
                                        .mensaje("Actualizado correctamente");
                }
                return new ResponseEntity<>(usuarioUpdate, HttpStatus.OK);
        }

        @GetMapping("/{username}")
        public Usuario obtenerUsuario(@PathVariable("username") String username) {
                return usuarioService.obtenerUsuario(username);
        }

        @DeleteMapping("/{usuarioId}")
        public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
                usuarioService.eliminarUsuario(usuarioId);
        }
}