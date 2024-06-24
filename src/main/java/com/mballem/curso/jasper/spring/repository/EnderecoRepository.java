package com.mballem.curso.jasper.spring.repository;

import com.mballem.curso.jasper.spring.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("select distinct e.uf from Endereco e order by e.uf desc")
    List<String> findUfs();

}
