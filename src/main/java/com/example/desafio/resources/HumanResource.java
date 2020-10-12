package com.example.desafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.entities.Human;

@RestController
@RequestMapping(value = "/human")
public class HumanResource {

	@GetMapping
	public ResponseEntity<Human> findAll(){
		Human h = new Human(12, 1, 2);
		return ResponseEntity.ok().body(h);
	}
	
}
