/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.repository;

import com.maptriz.devcase.controller.form.UsuarioForm;
import com.maptriz.devcase.model.Usuario;
import java.time.LocalDate;

/**
 *
 * @author giovanacgois
 */
public interface UsuarioRepositoryCustom {

    boolean validarCPF(String CPF);

    boolean verificarMaioridade(LocalDate dataNascimento);

    boolean validarCampos(UsuarioForm form);

    Usuario deletar(Usuario usuario);

}
