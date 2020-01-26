package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> findByCorreoAndPassword(String correo, String password);

    Optional<Usuario> findByNombre(String nombre);
}
