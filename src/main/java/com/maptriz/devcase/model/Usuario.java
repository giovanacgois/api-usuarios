/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author giovanacgois
 */
@Entity
@Table (name="TB_USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //criar automaticamente os IDs 
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    @Column(unique=true)
    private String cpf;
    private LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataAtualização = LocalDate.now();
    private boolean deletado;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

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
     * @return the dataCadastro
     */
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void LocalDate(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the dataAtualização
     */
    public LocalDate getDataAtualização() {
        return dataAtualização;
    }

    /**
     * @param dataAtualização the dataAtualização to set
     */
    public void setDataAtualização(LocalDate dataAtualização) {
        this.dataAtualização = dataAtualização;
    }

    /**
     * @return the deletado
     */
    public boolean isDeletado() {
        return deletado;
    }

    /**
     * @param deletado the deletado to set
     */
    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
}
