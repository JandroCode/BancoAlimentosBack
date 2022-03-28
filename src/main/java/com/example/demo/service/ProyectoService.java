package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProyectoDTO;

public interface ProyectoService {
	
	//Listado de proyectos
	List<ProyectoDTO> listaProyectos();
	
	//Guardar proyecto
	ProyectoDTO guardarEntidad(ProyectoDTO proyectoDTO);

}
