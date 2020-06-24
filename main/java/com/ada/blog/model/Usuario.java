package com.ada.blog.model;

public class Usuario {

	 private long IdUsuario;
	private String Nombre;
	private String Apellido;
	private String Contrasena;
	private String Correo;
	private Long IdGrupo;
	public long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public Long getIdGrupo() {
		return IdGrupo;
	}
	
	
	public void setIdGrupo(int int1) {
		// TODO Auto-generated method stub
		
	}
	 

}
