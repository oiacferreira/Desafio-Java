package com.example.desafio.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private int lifePoints;
	private int str;
	private int agi;

	public Persona() {
	}

	public Persona(String id, String name, int lifePoints, int str, int agi) {
		super();
		this.id = id;
		this.name = name;
		this.lifePoints = lifePoints;
		this.str = str;
		this.agi = agi;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agi;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + lifePoints;
		result = prime * result + str;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (agi != other.agi)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lifePoints != other.lifePoints)
			return false;
		if (str != other.str)
			return false;
		return true;
	}

	

	public int initiative() {
		return Dice.RollDice(19) + agi;
	}

	public int attack() {
		return Dice.RollDice(19) + agi + Sword.getAtack();
	}

	public int defense() {
		return (Dice.RollDice(19) + agi + Sword.getDefense());
	}

	public int damage() {
		return (Dice.RollDice(5) + str);
	}

}
