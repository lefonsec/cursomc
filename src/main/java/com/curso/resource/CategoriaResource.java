package com.curso.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.domain.Categoria;
import com.curso.dto.CategoriaDTO;
import com.curso.servicies.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService catService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = catService.finById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> findAll(Pageable pageable){
		Page<CategoriaDTO> lista = catService.findAll(pageable);
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		obj = catService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> upadate(@PathVariable Long id, @RequestBody Categoria obj){
		obj = catService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		catService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
