package com.ada.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ada.blog.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setApellido(rs.getString("Apellido"));
		usuario.setContrasena(rs.getString("Contrasena"));
		usuario.setCorreo(rs.getString("Correo"));
		usuario.setIdUsuario(rs.getInt("IdUsuario"));
		usuario.setIdGrupo(rs.getInt("IdGrupo"));
		usuario.setNombre(rs.getString("Nombre"));
		
		return usuario;
	}

	

}
