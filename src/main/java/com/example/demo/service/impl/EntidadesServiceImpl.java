package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EntidadDTO;
import com.example.demo.dto.converter.EntidadesConverter;
import com.example.demo.entities.Entidad;
import com.example.demo.repository.IEntidadDAO;
import com.example.demo.service.IEntidadesService;

@Service
public class EntidadesServiceImpl implements IEntidadesService {
	
	private IEntidadDAO entidadesDAO;
	private EntidadesConverter entidadesConverter;
	
	
	@Autowired
	public EntidadesServiceImpl(IEntidadDAO entidadesDAO,EntidadesConverter entidadesConverter ) {
		this.entidadesDAO = entidadesDAO;
		this.entidadesConverter = entidadesConverter;
	}
	
	@Override
	public List<EntidadDTO> listaEntidades() {
		
		  List<Entidad> entidades = entidadesDAO.findAll();
		  List<EntidadDTO> entidadesDTOs =  entidadesConverter.convertListOfEntityToListOfDto(entidades);
		  
		  return entidadesDTOs;
	}

	@Override
	public EntidadDTO guardarEntidad(EntidadDTO entidadesDTO) {
		
		Entidad entidades = entidadesConverter.convertDtoToEntity(entidadesDTO);
		Entidad  entidadGuardada = entidadesDAO.save(entidades);
		
		return entidadesConverter.convertEntityToDto(entidadGuardada);
	}
	
	

	@Override
	public EntidadDTO buscarPorId(Long id) {
		
		Entidad entidad = entidadesDAO.findById(id).orElse(null);
		EntidadDTO entidadDTO = entidadesConverter.convertEntityToDto(entidad);
		
		return entidadDTO;
	}

	@Override
	public void eliminarEntidad(Long id) {
		entidadesDAO.deleteById(id);
	}
	
	
	
}
