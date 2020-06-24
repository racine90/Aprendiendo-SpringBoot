package com.ada.blog.model;

public class UsuarioMetadata {

	private long IdUsuarioMetaData;
	private long IdUsuario;
	private String Clave;
	private String Valor;
	private String Tipo;
	public long getIdUsuarioMetaData() {
		return IdUsuarioMetaData;
	}
	public void setIdUsuarioMetaData(long idUsuarioMetaData) {
		IdUsuarioMetaData = idUsuarioMetaData;
	}
	public long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
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

}
