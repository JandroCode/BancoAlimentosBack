package com.example.demo.dto;

import java.io.Serializable;

public class EntidadDTO implements Serializable {
	
	
	private Long id;
	private String nombre;
	
	
	public EntidadDTO() {
		
	}

	public EntidadDTO(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

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




	private static final long serialVersionUID = 1L;
	
	

}
