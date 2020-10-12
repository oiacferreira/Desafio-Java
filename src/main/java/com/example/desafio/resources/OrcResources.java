package com.example.desafio.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.entities.Orc;

@RestController
@RequestMapping(value = "/orc")
public class OrcResources {
	@GetMapping
	public ResponseEntity<Orc> findAll(){
		Orc o = new Orc(20, 2, 0);
		return ResponseEntity.ok().body(o);
	}

}
