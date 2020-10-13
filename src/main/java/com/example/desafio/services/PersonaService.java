package com.example.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.domain.Persona;
import com.example.desafio.repository.PersonaRepository;


@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository repo;
	
	public List<Persona> findAll(){		
		return repo.findAll();
	}
}
