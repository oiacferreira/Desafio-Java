package com.example.desafio.entities;

public class Sword extends Weapon {

	private static int atack = 2;
	private static int defense = 1;

	public Sword() {
		super();
	}

	public static int getAtack() {
		return atack;
	}

	public static int getDefense() {
		return defense;
	}

}
