package com.tienda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;
import com.tienda.model.payload.mensajeResponse;
import com.tienda.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

        @Autowired
        private IUsuarioService usuarioService;

        @GetMapping("/listarUsuarios")
        public String listar(Model model) {
                List<Usuario> usuarios =  usuarioService.Listar();
                model.addAttribute("usuarios", usuarios);
                return "/usuario/listarUsuarios";
        }

        @PostMapping("/registrarUsuario")
        public ResponseEntity<?> create(@ModelAttribute UsuarioDto usuarioDto) {
                Usuario usuarioSave = null;
                try {
                        usuarioSave = usuarioService.Guardar(usuarioDto);
                        return new ResponseEntity<>(mensajeResponse.builder()
                                        .mensaje("Guardado Correctamente")
                                        .object(UsuarioDto.builder()
                                                        .idUsuario(usuarioSave.getIdUsuario())
                                                        .nombre(usuarioSave.getNombre())
                                                        .correo(usuarioSave.getCorreo())
                                                        .password(usuarioSave.getPassword())
                                                        .build())
                                        .build(), HttpStatus.CREATED);

                } catch (DataAccessException exDT) {
                        return new ResponseEntity<>(
                                        mensajeResponse.builder()
                                                        .mensaje(exDT.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("/actualizarUsuario/{id}")
        public ResponseEntity<?> update(@ModelAttribute UsuarioDto usuarioDTO, @PathVariable Integer id) {
                Usuario usuarioUpdate = null;
                try {

                        if (usuarioService.ExisteId(id)) {
                                usuarioDTO.setIdUsuario(id);
                                usuarioUpdate = usuarioService.Guardar(usuarioDTO);
                                return new ResponseEntity<>(mensajeResponse.builder()
                                                .mensaje("Guardado Correctamente")
                                                .object(UsuarioDto.builder()
                                                                .idUsuario(usuarioUpdate.getIdUsuario())
                                                                .nombre(usuarioUpdate.getNombre())
                                                                .correo(usuarioUpdate.getCorreo())
                                                                .password(usuarioUpdate.getPassword())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
                        } else {
                                return new ResponseEntity<>(
                                                mensajeResponse.builder()
                                                                .mensaje("El registro que intenta actualizar no se encuentra en la Base de Datos")
                                                                .object(null)
                                                                .build(),
                                                HttpStatus.NOT_FOUND);
                        }
                } catch (DataAccessException exDT) {
                        return new ResponseEntity<>(
                                        mensajeResponse.builder()
                                                        .mensaje(exDT.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @DeleteMapping("/eliminarUsuario/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) { // ResponseEntity maneja todas las respuestas HTTP
                try {
                        Usuario usuarioDelete = usuarioService.ListarId(id);
                        usuarioService.Eliminar(usuarioDelete);
                        return new ResponseEntity<>(usuarioDelete, HttpStatus.NO_CONTENT);
                } catch (DataAccessException exDT) {
                        return new ResponseEntity<>(
                                        mensajeResponse.builder()
                                                        .mensaje(exDT.getMessage())
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @GetMapping("/consultarUsuario/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {
                Usuario usuario = usuarioService.ListarId(id);

                if (usuario == null) {
                        return new ResponseEntity<>(
                                        mensajeResponse.builder()
                                                        .mensaje("El registro no existe!!")
                                                        .object(null)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }
                return new ResponseEntity<>(
                                mensajeResponse.builder()
                                                .mensaje("Consulta Exitosa")
                                                .object(UsuarioDto.builder()
                                                                .idUsuario(usuario.getIdUsuario())
                                                                .nombre(usuario.getNombre())
                                                                .correo(usuario.getCorreo())
                                                                .password(usuario.getPassword())
                                                                .build())
                                                .build(),
                                HttpStatus.OK);
        }
}
