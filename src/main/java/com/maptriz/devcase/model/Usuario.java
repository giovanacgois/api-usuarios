/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.model;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) //criar automaticamente os IDs 
   private long id;
   private String nome;
   private Calendar dataNascimento;
   private String cpf;
   private Calendar dataCadastro;
   private Calendar dataAtualização;
   private boolean deletado;

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
    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Calendar dataNascimento) {
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
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the dataAtualização
     */
    public Calendar getDataAtualização() {
        return dataAtualização;
    }

    /**
     * @param dataAtualização the dataAtualização to set
     */
    public void setDataAtualização(Calendar dataAtualização) {
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
