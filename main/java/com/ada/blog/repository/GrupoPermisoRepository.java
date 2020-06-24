package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.GrupoPermisoMapper;
import com.ada.blog.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRepo{
	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(GrupoPermiso object) {
		try {
			String sql = String.format("insert into GrupoPermiso(IdGrupo, IdPermiso)   value ('%d','%d')",
					object.getIdGrupo(), object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean update(GrupoPermiso object) {
		if (object.getIdGrupo() > 0) {
			String sql = String.format("update Contenido set IdPermiso ='%d' where IdGrupo= '%d'",
					object.getIdGrupo(), object.getIdPermiso());
			jdbcTemplate.execute(sql);
		}
		return false;
	}


	@Override
	public List<GrupoPermiso> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from GrupoPermiso", new GrupoPermisoMapper());

		}

	@Override
	public GrupoPermiso findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from GrupoPermiso where IdGrupoPermiso =?", params,
				new GrupoPermisoMapper());

	}
}
