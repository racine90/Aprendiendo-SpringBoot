package com.ada.blog.model;

public class Contenido {

	private long IdContenido;
	private String Tipo;
	private String Contenido;
	private long IdPost;
	public long getIdComentario() {
		return IdContenido;
	}
	public void setIdComentario(long idComentario) {
		IdContenido = IdContenido;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getContenido() {
		return Contenido;
	}
	public void setContenido(String contenido) {
		Contenido = contenido;
	}
	public long getIdPost() {
		return IdPost;
	}
	public void setIdPost(long idPost) {
		IdPost = idPost;
	}
	public int getIdContenido() {
		// TODO Auto-generated method stub
		return 0;
	}
}
