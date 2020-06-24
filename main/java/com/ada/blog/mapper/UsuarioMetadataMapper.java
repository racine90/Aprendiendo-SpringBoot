package com.ada.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ada.blog.model.UsuarioMetadata;

public class UsuarioMetadataMapper implements RowMapper<UsuarioMetadata>{

	@Override
	public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
	     UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
	     usuarioMetadata.setClave(rs.getString("Clave"));
	     usuarioMetadata.setIdUsuario(rs.getInt("IdUsuario"));
	     usuarioMetadata.setIdUsuarioMetaData(rs.getInt("IdUsuarioMetaData"));
	     usuarioMetadata.setTipo(rs.getString("Tipo"));
	     usuarioMetadata.setValor(rs.getString("Valor"));
		return usuarioMetadata;
	}

	

}
