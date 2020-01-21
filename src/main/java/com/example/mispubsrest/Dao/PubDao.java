package com.example.mispubsrest.Dao;

import com.example.mispubsrest.Modelos.Pub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PubDao extends JpaRepository<Pub, Integer> {
}
