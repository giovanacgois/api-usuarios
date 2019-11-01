/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.controller.dto;

import com.maptriz.devcase.model.Usuario;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author giovanacgois
 */
public class UsuarioDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private LocalDate dataCadastro;
    private LocalDate dataAtualização;
    private boolean deletado;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.dataCadastro = usuario.getDataCadastro();
        this.dataAtualização = usuario.getDataAtualização();
        this.dataNascimento = usuario.getDataNascimento();
        this.deletado = usuario.isDeletado();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the dataNascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the dataCadastro
     */
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @return the dataAtualização
     */
    public LocalDate getDataAtualização() {
        return dataAtualização;
    }

    /**
     * @return the deletado
     */
    public boolean isDeletado() {
        return deletado;
    }

    public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}
