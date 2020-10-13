package com.example.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio.entities.Human;
import com.example.desafio.entities.Orc;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);

		Human h = new Human(12, 1, 2);
		Orc o = new Orc(20, 2, 0);
		int h_lifepoints;
		int o_lifepoints;
		int init_human = 0;
		int init_orc = 0;
		int turn = 1;
		int atk;
		int def;
		int damage;
		String init_win;
		String winner = "";

		h_lifepoints = h.getLifePoints();
		o_lifepoints = o.getLifePoints();

		// public String teste(){
		// do

		while ((h_lifepoints > 0) && (o_lifepoints > 0)) {

			while (init_human == init_orc) {
				System.out.println("Rolem os dados para decidir quem ataca: ");
				init_human = h.initiative();
				System.out.println("O humano rolou " + init_human);
				init_orc = o.initiative();
				System.out.println("O orc rolou " + init_orc + "\n");

			}

			if (init_human > init_orc) {
				//System.out.println("O humano ataca dessa vez!");
				init_win = "Humano";
			} else {
				//System.out.println("O orc ataca dessa vez!");
				init_win = "Orc";
			}
			// return init_win;
			System.out.println(turn + "º turno.");

			if (init_win == "Humano") {
				atk = h.attack();
				System.out.println("O valor de ataque do humano foi:" + atk);
				def = o.defense();
				System.out.println("O valor de defesa do orc foi:" + def);
				if (atk > def) {
					damage = h.damage();
					System.out.println("O valor de dano desferido foi:" + damage);
					// o.setLifePoints(o.getLifePoints() - damage);
					o_lifepoints -= damage;
					System.out.println(" ");
					winner = "Humano";
					System.out.println("Pontos de vida restantes do orc:" + o_lifepoints);
				} else {
					System.out.println("O ataque foi bloqueado \n");
				}
			}

			if (init_win == "Orc") {
				atk = o.attack();
				System.out.println("O valor de ataque do orc foi:" + atk);
				def = h.defense();
				System.out.println("O valor de defesa do humano foi:" + def);
				if (atk > def) {
					damage = o.damage();
					System.out.println("O valor de dano desferido foi:" + damage);
					// h.setLifePoints(h.getLifePoints() - damage);
					h_lifepoints -= damage;
					System.out.println(" ");
					winner = "Orc";
					System.out.println("Pontos de vida restantes do humano:" + h_lifepoints);
				} else {
					System.out.println("O ataque foi bloqueado \n");
				}

			}
			turn++;
			init_human = 0;
			init_orc = 0;
		}
		System.out.println("A batalha foi vencida pelo " + winner);

	}

}
