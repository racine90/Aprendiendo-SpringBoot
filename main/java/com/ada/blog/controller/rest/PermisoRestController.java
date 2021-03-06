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

import com.ada.blog.model.Permiso;
import com.ada.blog.model.RepBase;
import com.ada.blog.repository.PermisoRepository;

@RestController
@RequestMapping("/api/v1/permiso")
public class PermisoRestController {

	@Autowired
	private PermisoRepository repository;

	@PutMapping
	public ResponseEntity<RepBase> save(@RequestBody Permiso permiso) {
		return ResponseEntity.ok(new RepBase(repository.save(permiso)));

	}

	@PostMapping
	public ResponseEntity<RepBase> update(@RequestBody Permiso permiso) {
		return ResponseEntity.ok(new RepBase(repository.update(permiso)));
	}

	@GetMapping
	public ResponseEntity<List<Permiso>> findAll(SpringDataWebProperties.Pageable pegeable) {
		return ResponseEntity.ok(repository.findAll(pegeable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Permiso> findById(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id));
	}
}
