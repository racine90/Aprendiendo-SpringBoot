package com.ada.blog.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

//Interfaz generica
public interface BaseRepo <T>{
	public boolean save(T object);
	public boolean update (T object);
	public List<T> findAll(Pageable pegeable);
	public T findById(int Id);

		

}
