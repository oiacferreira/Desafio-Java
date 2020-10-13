package com.example.desafio.entities;
import java.util.Random;

public class Dice {
	private static Random random = new Random();
	
	public Dice(){
		
	}

	public static int RollDice(int sides) {
		int rnd = random.nextInt(sides) + 1;
		return rnd;
	}
}
