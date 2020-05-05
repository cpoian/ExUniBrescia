package it.unibs.ing.fp.pokemon;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class PokemonMain {

	private static final String MESSAGGIO_INIZIALE = "Pokemon the game!";

	public static void main(String[] args) {
		System.out.println(MESSAGGIO_INIZIALE);
		boolean aggiungi;
		
		ArrayList<Pokemon> listaPokemonA = new ArrayList<Pokemon>();
		listaPokemonA.add(Pokemon.BLASTOISE);
		listaPokemonA.add(Pokemon.CHARIZARD);
		listaPokemonA.add(Pokemon.VENUSAUR);
		listaPokemonA.add(Pokemon.MEWTWO);
		Allenatore MasterA = new Allenatore("Red", listaPokemonA);
		
		ArrayList<Pokemon> listaPokemonB = new ArrayList<Pokemon>();
		listaPokemonB.add(Pokemon.PIDGEOT);
		listaPokemonB.add(Pokemon.PIKACHU);
		listaPokemonB.add(Pokemon.DRAGONITE);
		listaPokemonB.add(Pokemon.GENGAR);
		Allenatore MasterB = new Allenatore("Blu", listaPokemonB);
		
		for(;;) {
			
			
			
		}
		
		
	}

}
