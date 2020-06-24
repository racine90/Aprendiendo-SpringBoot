package com.ada.blog.component;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.ada.blog.repository.CategoriaRepository;
import com.ada.blog.repository.UsuarioRepository;

////Clase para la configuracion de base de datos donde se va a realizar los tests.

///@Configuration
public class TestBaseConfiguration {
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_blog?useunicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword(" ");
		return dataSource;		
	}
	
	@Bean
	public CategoriaRepository categoriaRepository() {
		return new CategoriaRepository();
	}
	@Bean
	public UsuarioRepository usuarioRepository() {
		return new UsuarioRepository();
	}
}

