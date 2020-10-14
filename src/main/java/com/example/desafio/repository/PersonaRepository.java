package com.example.desafio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio.domain.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {


}
