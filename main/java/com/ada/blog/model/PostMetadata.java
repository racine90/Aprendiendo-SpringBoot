package com.ada.blog.model;

public class PostMetadata {

	private long IdPostMetaData;
	private String Clave;
	private String Valor;
	private String Tipo;
	private long IdPost;
	public long getIdPostMetaData() {
		return IdPostMetaData;
	}
	public void setIdPostMetaData(long idPostMetaData) {
		IdPostMetaData = idPostMetaData;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public long getIdPost() {
		return IdPost;
	}
	public void setIdPost(long idPost) {
		IdPost = idPost;
	}
}
