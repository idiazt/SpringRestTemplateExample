package com.exampleresttemplate.prueba.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = -5354958900648415195L;
	
	private Long id;
	private String nombre;
	private List<RolDTO> roles = new ArrayList<RolDTO>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<RolDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}
	
}
