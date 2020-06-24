package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.ContenidoMapper;
import com.ada.blog.model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Contenido contenido) {
		try {
			String sql = String.format("insert into contenido(Contenido, IdPost, Tipo)   value ('%s','%d','%s')",
					contenido.getContenido(), contenido.getIdPost(), contenido.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Contenido contenido) {
		if (contenido.getIdContenido() > 0) {
			String sql = String.format("update Contenido set Contenido ='%s', Tipo='%s' where IdContenido= '%d'",
					contenido.getContenido(), contenido.getTipo(), contenido.getIdContenido());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from Contenido", new ContenidoMapper());

	}

	@Override
	public Contenido findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Contenido where IdContenido =?", params,
				new ContenidoMapper());

	}
}
