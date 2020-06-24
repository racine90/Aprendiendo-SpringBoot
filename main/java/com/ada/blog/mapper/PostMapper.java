package com.ada.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ada.blog.model.Post;


public class PostMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post = new Post();
		post.setCategoria(rs.getInt("Categoria"));
		post.setExtracto(rs.getString("Extracto"));
		post.setIdPost(rs.getInt("IdPost"));
		post.setIdUsuario(rs.getInt("IdUsuario"));
		post.setImagenDestacada(rs.getString("ImagenDestacada"));
		post.setTipo(rs.getString("Tipo"));
		post.setTitulo(rs.getString("Titulo"));
		post.setUrl(rs.getNString("Url"));
		return post;
	}

	

}
