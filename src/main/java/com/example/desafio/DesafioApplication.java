package com.example.desafio;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio.domain.Persona;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		Persona human = new Persona();
		Persona orc = new Persona();

		ArrayList<Object> lista = null;

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

		// Conexão com o banco e busca dos personagens
		try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
			MongoDatabase database = mongoClient.getDatabase("rpg");
			MongoCollection<org.bson.Document> collection = database.getCollection("persona");

			try (MongoCursor<org.bson.Document> cur = collection.find().iterator()) {
				while (cur.hasNext()) {
					org.bson.Document doc = cur.next();
					Collection<Object> persona = doc.values();
					lista = new ArrayList<Object>(persona);
					if (lista.get(1).equals("Orc")) {
						orc = new Persona(lista.get(0).toString(), lista.get(1).toString(), lista.get(2).toString(),
								lista.get(3).toString(), lista.get(4).toString());
						System.out.println("nome " + orc.getName());

					} else if (lista.get(1).equals("Human")) {
						human = new Persona(lista.get(0).toString(), lista.get(1).toString(), lista.get(2).toString(),
								lista.get(3).toString(), lista.get(4).toString());
						System.out.println("nome " + human.getName());
					}
				}
			}

		}

		h_lifepoints = human.getLifePoints();
		o_lifepoints = orc.getLifePoints();

		// loop para iniciar a batalha em turnos
		while ((h_lifepoints > 0) && (o_lifepoints > 0)) {

			while (init_human == init_orc) {
				System.out.println("Rolem os dados para decidir quem ataca: ");
				init_human = human.initiative();
				System.out.println("O humano rolou " + init_human);
				init_orc = orc.initiative();
				System.out.println("O orc rolou " + init_orc + "\n");

			}

			if (init_human > init_orc) {
				init_win = "Humano";
			} else {
				init_win = "Orc";
			}
			System.out.println(turn + "º turno.");
			System.out.println(init_win + " ataca dessa vez!");

			if (init_win == "Humano") {
				atk = human.attack();
				System.out.println("O valor de ataque do humano foi:" + atk);
				def = orc.defense();
				System.out.println("O valor de defesa do orc foi:" + def);
				if (atk > def) {
					damage = human.damage();
					System.out.println("O valor de dano desferido foi:" + damage);
					o_lifepoints -= damage;
					winner = "Humano";
					System.out.println("Pontos de vida restantes do orc:" + o_lifepoints);
					System.out.println(" ");
				} else {
					System.out.println("O ataque foi bloqueado \n");
				}
			}

			if (init_win == "Orc") {
				atk = orc.attack();
				System.out.println("O valor de ataque do orc foi:" + atk);
				def = human.defense();
				System.out.println("O valor de defesa do humano foi:" + def);
				if (atk > def) {
					damage = orc.damage();
					System.out.println("O valor de dano desferido foi:" + damage);
					h_lifepoints -= damage;
					winner = "Orc";
					System.out.println("Pontos de vida restantes do humano:" + h_lifepoints);
					System.out.println(" ");
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
