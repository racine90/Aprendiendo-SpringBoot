package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.UsuarioMapper;
import com.ada.blog.model.Usuario;

@Repository
public class UsuarioRepository implements UsuarioRepo {
	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Usuario object) {
		try {
			String sql = String.format(
					"insert into Usuario (Nombre,Apellido, Contrasena, correo,IdGrupo)   value ('$s','$s','$s','$d')",
					object.getNombre(), object.getApellido(), object.getContrasena(), object.getCorreo(),
					object.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(Usuario object) {
		if (object.getIdUsuario() > 0) {
			String sql = String.format(
					"update Comentario set(Nombre,Apellido, Contrasena, correo,IdGrupo)   value ('%s','%s','%s','%d')"
							+ "where IdUsuario='%d",
					object.getNombre(), object.getApellido(), object.getContrasena(), object.getCorreo(),
					object.getIdGrupo());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Usuario> findAll(Pageable pegeable) {

		return jdbcTemplate.query("select * from Usuario", new UsuarioMapper());
	}

	@Override
	public Usuario findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Usuario where IdUsuario =?", params, new UsuarioMapper());

	}
}
