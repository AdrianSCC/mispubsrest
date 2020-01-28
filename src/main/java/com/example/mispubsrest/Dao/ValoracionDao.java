package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionDao extends JpaRepository<Valoracion, Integer> {
    List<Valoracion> findByIdpub(Integer idpub);
}
