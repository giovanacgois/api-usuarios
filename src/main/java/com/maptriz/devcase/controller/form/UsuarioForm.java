/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.controller.form;

import com.maptriz.devcase.model.Usuario;
import com.maptriz.devcase.repository.UsuarioRepository;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author giovanacgois
 */
public class UsuarioForm {

    @NotNull
    @Length(min = 3, message = "Preencha o nome completo.")
    private String nome;

    @NotNull
    //@CPF - poderia validar através de Bean Validation
    private String cpf;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario converter() {
        return new Usuario(nome, cpf, dataNascimento);
    }

    public Usuario atualizar(long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setCpf(this.cpf);
        usuario.setNome(this.nome);
        usuario.setDataNascimento(this.dataNascimento);
        usuario.setDataAtualização(LocalDate.now());
        return usuario;
    }
}
