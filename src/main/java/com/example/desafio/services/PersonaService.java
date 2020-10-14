package com.example.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.domain.Persona;
import com.example.desafio.repository.PersonaRepository;
import com.example.desafio.services.exception.ObjectNotFoundException;


@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository repo;
	
	public List<Persona> findAll(){		
		return repo.findAll();
	}
	
	public Persona findById(String id) {
		Optional<Persona> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
