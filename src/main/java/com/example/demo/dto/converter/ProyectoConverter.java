package com.example.demo.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProyectoDTO;
import com.example.demo.entities.Proyecto;

@Component
public class ProyectoConverter {
	
	//Convertir una lista de proyectos a una lista de proyectosDTO
	public List<ProyectoDTO> convertListOfEntityToListOfDto(List<Proyecto> proyecto) {
		
		List<ProyectoDTO> proyectosDTO = new ArrayList<>();
		
		ProyectoDTO proyectoDTO = new ProyectoDTO();
		
		for(Proyecto p:proyecto) {
			proyectoDTO.setId(p.getId());
			proyectoDTO.setNombre(p.getNombre());
			proyectoDTO.setFechaInicio(p.getFechaInicio());
			proyectoDTO.setFechaFin(p.getFechaFin());
			
			proyectosDTO.add(proyectoDTO);
		}
		
		return proyectosDTO;
	}
	
	//Convertir un proyecto en una proyectoDTO
	public ProyectoDTO convertEntityToDto(Proyecto proyecto) {
		
		ProyectoDTO proyectoDTO = new ProyectoDTO();
		
		proyectoDTO.setId(proyecto.getId());
		proyectoDTO.setNombre(proyecto.getNombre());
		proyectoDTO.setFechaInicio(proyecto.getFechaInicio());
		proyectoDTO.setFechaFin(proyecto.getFechaFin());
		
		return proyectoDTO;
	}
	
	//Convertir un proyectoDTO  a una proyecto
	public Proyecto convertDtoToEntity(ProyectoDTO  proyectoDTO) {
		
		Proyecto proyecto = new Proyecto();
		
		proyecto.setId(proyectoDTO.getId());
		proyecto.setNombre(proyectoDTO.getNombre());
		proyecto.setFechaInicio(proyecto.getFechaInicio());
		proyecto.setFechaFin(proyecto.getFechaFin());
		
		return proyecto;
	}

}
