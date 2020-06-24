package com.ada.blog.controller.rest;

import java.util.List;

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

import com.ada.blog.model.GrupoPermiso;
import com.ada.blog.model.RepBase;
import com.ada.blog.repository.GrupoPermisoRepository;


@RestController
@RequestMapping("/api/v1/grupopermiso")
public class GrupoPermisoRestController {
	
	@Autowired
	private GrupoPermisoRepository repository;

	@PutMapping
	public ResponseEntity<RepBase> save(@RequestBody GrupoPermiso grupopermiso) {
		return ResponseEntity.ok(new RepBase(repository.save(grupopermiso)));

	}

	@PostMapping
	public ResponseEntity<RepBase> update(@RequestBody GrupoPermiso grupopermiso) {
		return ResponseEntity.ok(new RepBase(repository.update(grupopermiso)));
	}

	@GetMapping
	public ResponseEntity<List<GrupoPermiso>> findAll(SpringDataWebProperties.Pageable pegeable) {
		return ResponseEntity.ok(repository.findAll(pegeable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<GrupoPermiso> findById(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id));
	}
}
