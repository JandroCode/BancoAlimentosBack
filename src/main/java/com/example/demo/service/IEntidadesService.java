package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EntidadDTO;

public interface IEntidadesService {
	
	//Lista de entidades
	List<EntidadDTO> listaEntidades();
	
	//Guardar entidad
	EntidadDTO guardarEntidad(EntidadDTO entidadesDTO);
	
	//Buscar entidad por id
	EntidadDTO buscarPorId(Long id);
	
	//Eliminar entidades
	void eliminarEntidad(Long id);
	
	

}
