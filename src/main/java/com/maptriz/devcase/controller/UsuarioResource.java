/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.controller;

import com.maptriz.devcase.model.Usuario;
import com.maptriz.devcase.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author giovanacgois
 */
@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {
   
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
    return usuarioRepository.findAll();
    }
    
    @GetMapping("/usuario/{id}")
    public Usuario listaUsuarioUnico(@PathVariable(value="id")long id){
    return usuarioRepository.findById(id);
    }
}
