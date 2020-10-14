package com.example.desafio.dto;

import java.io.Serializable;

import com.example.desafio.domain.Persona;

public class PersonaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int lifePoints;
	private int str;
	private int agi;
	
	public PersonaDTO() {
		
	}
	public PersonaDTO(Persona obj) {
		id = obj.getId();
		name = obj.getName();
		lifePoints = obj.getLifePoints();
		str = obj.getStr();
		agi = obj.getAgi();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	
	
}
