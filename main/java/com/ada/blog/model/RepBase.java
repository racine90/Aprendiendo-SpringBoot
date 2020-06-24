package com.ada.blog.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Si alguna propiedad viene nula que no la muestre
public class RepBase {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // manejo de fechas
	private Date timestamp = new Date();

	@SuppressWarnings("unused")
	private Object response;

	public RepBase() {

	}

	public RepBase(Object response) {
		this.response = response;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Object getResponse() {
		return response;
	}

	public void SetResponse(Object response) {
		this.response = response;
	}

}
