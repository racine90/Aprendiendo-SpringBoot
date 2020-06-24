package com.ada.blog.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ada.blog.model.Categoria;
import com.ada.blog.model.RepBase;
import com.ada.blog.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaRestController {

	@Autowired

	private CategoriaRepository categoriaRepository;

	@PutMapping
	public ResponseEntity<RepBase> save(@RequestBody @Valid Categoria categoria) {
		return ResponseEntity.ok(new RepBase(categoriaRepository.save(categoria)));

	}

	@PostMapping
	public ResponseEntity<RepBase> update(@RequestBody @Valid Categoria categoria) {
		return ResponseEntity.ok(new RepBase(categoriaRepository.update(categoria)));
	}

	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(SpringDataWebProperties.Pageable pegeable) {
		return ResponseEntity.ok(categoriaRepository.findAll(pegeable));

}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable int id) {
		return ResponseEntity.ok(categoriaRepository.findById(id));
	}
}

