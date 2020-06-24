package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ada.blog.mapper.GrupoMapper;
import com.ada.blog.model.Grupo;

@Repository
public class GrupoRepository implements GrupoRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Grupo object) {
		try {
			String sql = String.format("insert into Grupo(IdGrupo, Nombre)   value ('%d','%s')", object.getIdGrupo(),
					object.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Grupo object) {
		if (object.getIdGrupo() > 0) {
			String sql = String.format("update Grupo set Nombre ='$s' where IdGrupo= '%d'", object.getIdGrupo(),
					object.getNombre());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Grupo> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from Grupo", new GrupoMapper());

	}

	@Override
	public Grupo findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Grupo where IdGrupo =?", params, new GrupoMapper());

	}
}
