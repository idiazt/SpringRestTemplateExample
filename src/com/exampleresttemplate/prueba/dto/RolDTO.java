package com.exampleresttemplate.prueba.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {

	private static final long serialVersionUID = 5195485844454842341L;
	
	private Long id;
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
