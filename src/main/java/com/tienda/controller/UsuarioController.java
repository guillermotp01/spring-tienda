package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.model.dto.UsuarioDto;
import com.tienda.model.entity.Usuario;
import com.tienda.model.payload.mensajeResponse;
import com.tienda.serviceInterface.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

        @Autowired
        private IUsuarioService usuarioService;

        @GetMapping("/listarUsuarios")
        public ResponseEntity<Page<Usuario>> list(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "2") int size) {
                var result = usuarioService.Listar(page, size);
                return new ResponseEntity<>(result, HttpStatus.OK);
        }

        @PostMapping("/registrarUsuario")
        public ResponseEntity<Usuario> save(@RequestBody UsuarioDto usuarioDto) {
                Usuario usuarioSave = null;
                usuarioSave = usuarioService.Guardar(usuarioDto);
                if (usuarioSave != null) {
                        mensajeResponse.builder()
                                        .mensaje("Guardado Correctamente");
                }
                return new ResponseEntity<>(usuarioSave, HttpStatus.OK);
        }

        @PutMapping("/actualizarUsuario/{id}")
        public ResponseEntity<?> update(@RequestBody UsuarioDto usuarioDTO, @PathVariable Integer id) {
                Usuario usuarioUpdate = usuarioService.Actualizar(usuarioDTO, id);

                if (usuarioUpdate != null) {
                        mensajeResponse.builder()
                                        .mensaje("Actualizado correctamente");
                }
                return new ResponseEntity<>(usuarioUpdate, HttpStatus.OK);
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
