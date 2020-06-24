package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.CategoriaMapper;
import com.ada.blog.model.Categoria;

//@Repository
public class CategoriaRepository implements CategoriaRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	public boolean save(Categoria categoria) {
		try {
			String sql = String.format(
					"insert into Categoria(Nombre,Descripcion,CategoriaSuperior)   value ('%s','%s','%d')",
					categoria.getNombre(), categoria.getDescripcion(), categoria.getCategoriaSuperior());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean update(Categoria categoria) {
		if (categoria.getCategoriaSuperior() > 0) {
			String sql = String.format(
					"update Comentario set(Nombre,Descripcion,CategoriaSuperior)   value ('%s','%s','%d')"
							+ "where IdCategoria='$d",
					categoria.getNombre(), categoria.getDescripcion(), categoria.getCategoriaSuperior(),
					categoria.getIdCategoria());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Categoria> findAll(Pageable pegeable) {

		return jdbcTemplate.query("select * from Categoria", new CategoriaMapper());
	}

	@Override
	public Categoria findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Categoria where IdCategoria =?", params,
				new CategoriaMapper());

		
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
