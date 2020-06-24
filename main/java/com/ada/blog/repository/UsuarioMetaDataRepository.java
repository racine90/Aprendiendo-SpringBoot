package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ada.blog.mapper.UsuarioMetadataMapper;
import com.ada.blog.model.UsuarioMetadata;

@Repository
public class UsuarioMetaDataRepository implements UsuarioMetaDataRepo {
	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);}

	@Override
	public boolean save(UsuarioMetadata object) {
		try {
			String sql = String.format(
					"insert into UsuarioMetadata (IdUsuario, Clave, Valor,Tipo)   value ('%d','%s','%s','%s')",
					object.getIdUsuario(), object.getClave(), object.getClave(), object.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(UsuarioMetadata object) {
		if (object.getIdUsuario() > 0) {
			String sql = String.format(
					"update UsuarioMetadata set(IdUsuario, Clave, Valor,Tipo)   value ('%d','%s','%s','%s')"
							+ "where IdMetataData='%d",
					object.getIdUsuario(), object.getClave(), object.getClave(), object.getTipo());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from UsuarioMetadata", new UsuarioMetadataMapper());
	}

	@Override
	public UsuarioMetadata findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from UsuarioMetadata where IdUsuarioMetada =?", params,
				new UsuarioMetadataMapper());

	}
}
