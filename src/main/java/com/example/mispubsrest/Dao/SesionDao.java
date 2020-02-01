package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SesionDao extends JpaRepository<Sesion, Integer> {

    Optional<Sesion> findByIdusuario(Integer id);
}
