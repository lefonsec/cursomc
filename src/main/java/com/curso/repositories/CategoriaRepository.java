package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.domain.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
