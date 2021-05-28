package com.curso.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepository;
	
	public Categoria finById(Long id) {
		Optional<Categoria> obj = catRepository.findById(id);
		return obj.get();
	}
}
