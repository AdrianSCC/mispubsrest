package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Pub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PubDao extends JpaRepository<Pub, Integer> {
    Optional<Pub> findByNombre(String nombre);

    List<Pub> findByEstilo(String estilo);
}
