package com.example.desafio.entities;

import java.io.Serializable;

public class Human implements Serializable {

	private static final long serialVersionUID = 1L;
	private int lifePoints = 12;
	private int str = 1;
	private int agi = 2;

	public Human() {
	}

	public Human(int lifePoints, int str, int agi) {
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
		return Dice.RollDice(20) + agi;
	}

	public int attack() {
		return Dice.RollDice(20) + agi + Sword.getAtack();
	}

	public int defense() {
		return (Dice.RollDice(20) + agi + Sword.getDefense());
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
		Human other = (Human) obj;
		if (agi != other.agi)
			return false;
		if (lifePoints != other.lifePoints)
			return false;
		if (str != other.str)
			return false;
		return true;
	}

}
