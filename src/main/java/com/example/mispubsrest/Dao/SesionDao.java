package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionDao extends JpaRepository<Sesion, Integer> {
}
