package com.mballem.curso.jasper.spring.repository;

import com.mballem.curso.jasper.spring.entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NiveisRepository extends JpaRepository<Nivel, Long> {

    @Query("select n.nivel from Nivel n")
    List<String> findNiveis();

}
