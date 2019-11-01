/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.repository;

import com.maptriz.devcase.controller.form.UsuarioForm;
import com.maptriz.devcase.model.Usuario;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;

/**
 *
 * @author giovanacgois
 */
class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom {

    @Override
    public boolean validarCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char digito10, digito11;
        int soma, i, resto, numero, peso;

        try {
            // Verifica o 10º digito (1º dígito verificador):
            soma = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                numero = (int) (CPF.charAt(i) - 48); // 48 é a posição de '0' na tabela ASCII   
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)) {
                digito10 = '0';
            } else {
                digito10 = (char) (resto + 48);
            }

            // Verifica o 11º digito (2º dígito verificador):
            soma = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                numero = (int) (CPF.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11)) {
                digito11 = '0';
            } else {
                digito11 = (char) (resto + 48);
            }

            // Compara os digitos verificadores com os dígitos informados.
            if ((digito10 == CPF.charAt(9)) && (digito11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    @Override
    public boolean verificarMaioridade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        int idade = periodo.getYears();
        return (idade >= 18);
    }

    @Override
    public boolean validarCampos(UsuarioForm form) {
        if (validarCPF(form.getCpf())) {
            return verificarMaioridade(form.getDataNascimento());
        }
        return false;
    }

    @Override
    public Usuario deletar(Usuario usuario) {
        usuario.setDeletado(true);
        usuario.setDataAtualização(LocalDate.now());
        return usuario;
    }
}
