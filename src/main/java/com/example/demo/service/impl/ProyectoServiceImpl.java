package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProyectoDTO;
import com.example.demo.dto.converter.ProyectoConverter;
import com.example.demo.entities.Entidad;
import com.example.demo.entities.Proyecto;
import com.example.demo.repository.IProyectoDAO;
import com.example.demo.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	private IProyectoDAO proyectoDAO;
	private ProyectoConverter proyectoConverter;
	
	@Autowired
	public ProyectoServiceImpl(IProyectoDAO proyectoDAO, ProyectoConverter proyectoConverter) {
		this.proyectoDAO = proyectoDAO;
		this.proyectoConverter = proyectoConverter;
	}

	@Override
	public List<ProyectoDTO> listaProyectos() {
		
		  List<Proyecto> proyectos = proyectoDAO.findAll();
		  List<ProyectoDTO> proyectosDTOs =  proyectoConverter.convertListOfEntityToListOfDto(proyectos);
		  
		  return proyectosDTOs;
	
	}

	@Override
	public ProyectoDTO guardarEntidad(ProyectoDTO proyectoDTO) {
		
		Proyecto proyecto = proyectoConverter.convertDtoToEntity(proyectoDTO);
		Proyecto  entidadGuardada = proyectoDAO.save(proyecto);
		
		return proyectoConverter.convertEntityToDto(entidadGuardada);
		
		
		
	}
	



}
