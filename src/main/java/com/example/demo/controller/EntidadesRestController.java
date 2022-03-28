package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EntidadDTO;
import com.example.demo.entities.Entidad;
import com.example.demo.repository.IEntidadDAO;
import com.example.demo.service.IEntidadesService;
import com.example.demo.validations.EntidadesValidation;

@RestController
@RequestMapping("/api/entidades")
@CrossOrigin("*")
public class EntidadesRestController {

	private IEntidadesService entidadesService;
	private EntidadesValidation entidadesValidation;
	
	@Autowired
	public EntidadesRestController(IEntidadesService entidadesService,
			EntidadesValidation entidadesValidation) {
		this.entidadesService = entidadesService;
		this.entidadesValidation = entidadesValidation;
		
	}
	
	
	// Listar entidades
	@GetMapping("")
	public ResponseEntity<?> entidades(){
		Map<String, Object> response = new HashMap<>();
		
		List<EntidadDTO> entidadesDTO;
		
		try {
			
			entidadesDTO = entidadesService.listaEntidades();
			response.put("Entidades", entidadesDTO);
			
		}catch (DataAccessException e) {
			response.put("error", "Error de acceso a datos");
			response.put("data_access_error", e.getMostSpecificCause().getMessage());
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}
	
	
	//Guardar entidades
	@PostMapping("")
	public ResponseEntity<?> guardar(@RequestBody EntidadDTO entidadesDTO){
		Map<String, Object> response = new HashMap<>();
		
		EntidadDTO entidadesDataTransfer;
		
		if(entidadesValidation.camposVacios(response,entidadesDTO, "Los campos son obligatorios")) {
			response.put("error", "Los campos son obligatorios");
		}
		else {
			entidadesDataTransfer = entidadesService.guardarEntidad(entidadesDTO);
			response.put("success", "Entidad guardada");
			response.put("Entidad", entidadesDataTransfer);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}
	
	//Actualizar entidad
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EntidadDTO entidad){
		Map<String, Object> response = new HashMap<>();
		
		EntidadDTO entidadEncontrada = null;
		
		try {
			entidadEncontrada = entidadesService.buscarPorId(id);
			
		}catch (NullPointerException e) {
			response.put("NOT FOUND", "La entidad no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		
		if(entidadEncontrada != null) {
			
			try{
				entidadEncontrada.setNombre(entidad.getNombre());
				entidadesService.guardarEntidad(entidadEncontrada);
				
				response.put("Entidad actualizada", entidadEncontrada);
				
			}catch (DataAccessException e) {
				response.put("error", "Error de acceso a datos");
				response.put("data_access_error", e.getMostSpecificCause().getMessage());
				
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}
	
	//Eliminar entidad
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
	
		try{
			entidadesService.eliminarEntidad(id);
			response.put("success", "Entidad eliminada");
			
		}catch (DataAccessException e) {
			response.put("error", "La entidad no existe");
			response.put("data_access_error", e.getMostSpecificCause().getMessage());
				
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
	    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

	

	

}
