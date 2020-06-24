package com.ada.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ada.blog.model.PostMetadata;

public class PostMetadataMapper implements RowMapper<PostMetadata> {

	@Override
	public PostMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostMetadata postMetadata= new PostMetadata();
		postMetadata.setClave(rs.getString("Clave"));
		postMetadata.setIdPost(rs.getInt("IdPost"));
		postMetadata.setIdPostMetaData(rs.getInt("IdPostMetaData"));
		postMetadata.setTipo(rs.getString("Tipo"));
		postMetadata.setValor(rs.getString("Valor"));
		return postMetadata;
	}

}
