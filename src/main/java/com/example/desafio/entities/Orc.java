package com.example.desafio.entities;

import java.io.Serializable;

public class Orc implements Serializable{

	private static final long serialVersionUID = 1L;
	private int lifePoints;
	private int str;
	private int agi;
	
	
	public Orc() {
	}


	public Orc(int lifePoints, int str, int agi) {
		super();
		this.lifePoints = lifePoints;
		this.str = str;
		this.agi = agi;
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
	
	public int initiative() {
		return Dice.RollDice(19) + agi;
	}
	
	public int attack() {
		return Dice.RollDice(19) + agi + Club.getAtack();
	}
	
	public int defense() {
		return Dice.RollDice(19) + agi + Club.getDefense();
	}
	
	public int damage() {
		return (Dice.RollDice(7) + str);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agi;
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
		Orc other = (Orc) obj;
		if (agi != other.agi)
			return false;
		if (lifePoints != other.lifePoints)
			return false;
		if (str != other.str)
			return false;
		return true;
	}
	
	
	
}

