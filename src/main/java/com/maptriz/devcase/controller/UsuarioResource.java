/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.controller;

import com.maptriz.devcase.controller.dto.UsuarioDTO;
import com.maptriz.devcase.controller.form.UsuarioForm;
import com.maptriz.devcase.model.Usuario;
import com.maptriz.devcase.repository.UsuarioRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author giovanacgois
 */
@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {

    @Autowired
    UsuarioRepository usuarioRepository;

    /*
    * GET 
     */
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDTO.converter(usuarios);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> listarUsuarioUnico(@PathVariable(value = "id") long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            if (usuario.get().isDeletado()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuarios/ativos")
    public List<UsuarioDTO> listarUsuariosAtivos() {
        List<Usuario> usuarios = usuarioRepository.findByDeletado(false);
        return UsuarioDTO.converter(usuarios);
    }

    @GetMapping("/usuarios/inativos")
    public List<UsuarioDTO> listarUsuariosInativos() {
        List<Usuario> usuarios = usuarioRepository.findByDeletado(true);
        return UsuarioDTO.converter(usuarios);
    }

    /*
    * POST  
     */
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
        if (usuarioRepository.validarCampos(form)) {
            Usuario usuario = form.converter();
            usuarioRepository.save(usuario);
            URI uri = uriBuilder.path("/api/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
            //devolve o código HTTP 201 (criado), ao invés do código 200;
            return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
        }
        return ResponseEntity.badRequest().build();
    }

    /*
    * DELETE  
     */
    @DeleteMapping("/usuario/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> deletarUsuario(@PathVariable(value = "id") long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            //usuarioRepository.deleteById(id); //deleta o registro do BD
            Usuario usuario = optional.get();
            if (usuario.isDeletado()) {
                return ResponseEntity.notFound().build();
            } else {
                usuario = usuarioRepository.deletar(usuario);
                return ResponseEntity.ok(new UsuarioDTO(usuario));
            }
        }
        return ResponseEntity.notFound().build();
    }

    /*
    * PUT  
     */
    @PutMapping("/usuario/{id}")
    @Transactional
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable(value = "id") long id,
            @RequestBody
            @Valid UsuarioForm form
    ) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            if (usuarioRepository.validarCampos(form)) {
                Usuario usuario = form.atualizar(id, usuarioRepository);
                return ResponseEntity.ok(new UsuarioDTO(usuario));
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }
}
