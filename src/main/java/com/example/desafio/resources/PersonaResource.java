package com.example.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.domain.Persona;
import com.example.desafio.services.PersonaService;

@RestController
@RequestMapping(value = "/persona")
public class PersonaResource {

	@Autowired
	private PersonaService service;

	@GetMapping
	public ResponseEntity<List<Persona>> findAll() {
		List<Persona> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
