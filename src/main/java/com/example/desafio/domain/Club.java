package com.example.desafio.domain;

public class Club extends Weapon {
	
	private static int atack = 1;
	private static int defense = 0;
	
	public Club() {
		super();
	}

	public static int getAtack() {
		return atack;
	}

	public static int getDefense() {
		return defense;
	}

	
}
