package com.curso.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.dto.CategoriaDTO;
import com.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository catRepository;

	public Categoria finById(Long id) {
		Optional<Categoria> obj = catRepository.findById(id);
		return obj.get();
	}

	public Page<CategoriaDTO> findAll(Pageable 	pageable) {
		Page<Categoria> result = catRepository.findAll(pageable);
		return result.map(x ->new CategoriaDTO(x));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return catRepository.save(obj);
	}

	public Categoria update(Long id, Categoria obj) {
		Categoria entity = catRepository.getById(id);
		update(entity, obj);
		return catRepository.save(entity);
	}

	private void update(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());

	}

	public void delete(Long id) {
		catRepository.deleteById(id);
	}
}
