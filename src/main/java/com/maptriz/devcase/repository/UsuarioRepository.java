/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maptriz.devcase.repository;

import com.maptriz.devcase.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author giovanacgois
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {

    public List<Usuario> findByDeletado(boolean b);
}
