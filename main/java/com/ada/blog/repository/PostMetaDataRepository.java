package com.ada.blog.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ada.blog.mapper.PostMetadataMapper;
import com.ada.blog.model.PostMetadata;

@Repository
public class PostMetaDataRepository implements PostMetaDataRepo {
	@Autowired
	private DataSource dataSoruce;
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public boolean save(PostMetadata object) {
		try {
			String sql = String.format(
					"insert into PostMetadata(Clave, Valor,Tipo,IdPost)   value ('%s','%s','%s','%d')",
					object.getClave(), object.getValor(), object.getTipo(), object.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(PostMetadata object) {
		if (object.getIdPost() > 0) {
			String sql = String.format(
					"update PostMetadata set Clave ='%s', Valor='%s',Tipo='%s',IdPost='%d',  where IdMetadata= '%d'",
					object.getClave(), object.getValor(), object.getTipo(), object.getIdPost());
			jdbcTemplate.execute(sql);
		}
		return false;
	}

	@Override
	public List<PostMetadata> findAll(Pageable pegeable) {
		return jdbcTemplate.query("select * from PostMetadata", new PostMetadataMapper());

	}

	@Override
	public PostMetadata findById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("select * from PostMetadata where IdPostMetada =?", params,
				new PostMetadataMapper());

	}
}
