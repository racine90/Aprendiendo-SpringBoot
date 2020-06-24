package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ada.blog.mapper.ComentarioMapper;
import com.ada.blog.model.Comentario;

@Repository
public class ComentarioRepository implements ComentarioRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Comentario comentario) {
		try {
			String sql = String.format(
					"insert into comentario(Comentario,IdPost,IdUsuario,Respuesta)   value ('%s','%d','%d','%d')",
					comentario.getComentario(), comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta());
			jdbcTemplate.execute(sql);
			return true;
			}catch (Exception e) {
				return false;
			}		
	}

	@Override
	public boolean update(Comentario comentario) {
		if (comentario.getIdComentario() >0) {
			String sql = String.format(
					"update Comentario set  ( Comentario,IdPost,IdUsuario,Respuesta)   value ('%s','%d','%d','%d')" + "where IdComentario='%d",
					comentario.getComentario(), comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta(), comentario.getIdComentario());
			jdbcTemplate.execute(sql);
		}
		return false;
	}


	@Override
	public List<Comentario> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from Comentario", new ComentarioMapper());
		
	}

	@Override
	public Comentario findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Categoria where IdComentario =?", params,
				new ComentarioMapper());
	}
	
}
