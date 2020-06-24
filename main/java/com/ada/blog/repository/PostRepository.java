package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.PostMapper;

import com.ada.blog.model.Post;
@Repository
public class PostRepository implements PostRepo {

	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(Post object) {
		try {
			String sql = String.format(
					"insert into Post (Titulo,Url, Estracto, IdUsuario,Categoria,ImagenDestacada, Tipo)   value ('%s','%s','%s','%d','%d','%s','%s')",
					object.getTitulo(), object.getUrl(), object.getExtracto(), object.getIdUsuario(),
					object.getCategoria(), object.getImagenDestacada(), object.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(Post object) {
		if (object.getIdPost() > 0) {
			String sql = String.format(
					"update Post set(Titulo,Url, Estracto, IdUsuario,Categoria,ImagenDestacada, Tipo)   value ('%s','%s','%s','%d','%d','%s','%s')"
							+ "where IdPost='$d",
					object.getTitulo(), object.getUrl(), object.getExtracto(), object.getIdUsuario(),
					object.getCategoria(), object.getImagenDestacada(), object.getTipo(), object.getIdPost());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<Post> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from Post", new PostMapper());
	}

	@Override
	public Post findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from Usuario where IdPost =?", params, new PostMapper());

	}
}
