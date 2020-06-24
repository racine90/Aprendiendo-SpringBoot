package com.ada.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ada.blog.model.Grupo;

public class GrupoMapper implements RowMapper<Grupo> {

	@Override
	public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grupo grupo = new Grupo();
		grupo.setIdGrupo(rs.getInt("IdGrup"));
		grupo.setNombre(rs.getString("Nombre"));
		
		return grupo;
	}

	

}
