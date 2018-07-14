package com.accenture.features.search;

public class Dato {
	private String correo;
	private String asunto;
	private String descripcion;
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Dato(String correo, String asunto, String descripcion) {
		
		this.correo = correo;
		this.asunto = asunto;
		this.descripcion = descripcion;
	}
	
	public Dato() {
		correo= "";
		asunto ="";
		descripcion = "";
	}
}
