package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
