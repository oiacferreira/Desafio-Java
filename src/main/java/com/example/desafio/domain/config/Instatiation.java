package com.example.desafio.domain.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.desafio.domain.Persona;
import com.example.desafio.repository.PersonaRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		personaRepository.deleteAll();
		
		Persona orc = new Persona("1", "Orc", 20, 1, 0);	
		Persona human = new Persona("2", "Human", 12, 2, 1); 
		
		personaRepository.saveAll(Arrays.asList(orc, human));
	}

}
