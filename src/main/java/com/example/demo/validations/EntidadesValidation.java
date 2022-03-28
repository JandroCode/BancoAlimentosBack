package com.example.demo.validations;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EntidadDTO;
import com.example.demo.service.impl.EntidadesServiceImpl;

@Component
public class EntidadesValidation {
	
	private EntidadesServiceImpl entidadesService;
	
	@Autowired
	public EntidadesValidation(EntidadesServiceImpl entidadesService){
		this.entidadesService = entidadesService;
	}
	
	
	// Validar campos vacíos 
	public boolean camposVacios(Map<String, Object> respuesta,EntidadDTO entidadesDTO, String mensaje){
		
		if(entidadesDTO.getNombre() == "") {
			respuesta.put("error", mensaje);
			
			return true;
		}
		
		return false;
	}
	


	
	
	

}
