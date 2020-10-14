package com.example.desafio.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.domain.Persona;
import com.example.desafio.dto.PersonaDTO;
import com.example.desafio.services.PersonaService;

@RestController
@RequestMapping(value = "/persona")
public class PersonaResource {

	@Autowired
	private PersonaService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PersonaDTO>> findAll() {
		List<Persona> list = service.findAll();
		List<PersonaDTO> listDTO = list.stream().map(x -> new PersonaDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PersonaDTO> findById(String id) {
		Persona obj = service.findById(id);
		return ResponseEntity.ok().body(new PersonaDTO(obj));
	}

}
