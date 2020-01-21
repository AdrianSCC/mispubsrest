package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}
