package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ada.blog.mapper.PermisoMapper;
import com.ada.blog.model.Permiso;

@Repository
public class PermisoRepository implements PermisoRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Permiso object) {
		try {
			String sql = String.format("insert into Permiso(Nombre) value ('%s')", object.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Permiso object) {
		if (object.getIdPermiso() > 0) {
			String sql = String.format("update Permiso set Nombre ='%s' where IdPermiso= '%d'", object.getNombre(),
					object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Permiso> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from Permiso", new PermisoMapper());

	}

	@Override
	public Permiso findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Permiso where IdPermiso =?", params, new PermisoMapper());

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
