package com.example.demo.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EntidadDTO;
import com.example.demo.entities.Entidad;

@Component
public class EntidadesConverter {
	

	//Convertir una lista de entidades a una lista de entidadesDTO
	public List<EntidadDTO> convertListOfEntityToListOfDto(List<Entidad> entidades) {
		
		List<EntidadDTO> entidadesDTO = new ArrayList<>();
		
		for(Entidad entidad: entidades) {
			entidadesDTO.add(new EntidadDTO(entidad.getId(), entidad.getNombre()));
		}
		
		return entidadesDTO;
	}
	
	//Convertir una entidad en una entidadDTO
	public EntidadDTO convertEntityToDto(Entidad entidades) {
		
		EntidadDTO entidadesDTO = new EntidadDTO();
		
		entidadesDTO.setId(entidades.getId());
		entidadesDTO.setNombre(entidades.getNombre());
		
		return entidadesDTO;
	}
	
	//Convertir una entidadDTO  a una entidad
	public Entidad convertDtoToEntity(EntidadDTO entidadesDTO) {
		
		Entidad entidades = new Entidad();
		
		entidades.setId(entidadesDTO.getId());
		entidades.setNombre(entidadesDTO.getNombre());
		
		return entidades;
	}
	
	
	

}
