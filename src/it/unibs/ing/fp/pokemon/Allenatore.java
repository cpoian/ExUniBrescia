package it.unibs.ing.fp.pokemon;

import java.util.ArrayList;

public class Allenatore {

	public static final int STARTING_LEVEL = 50;
	public static final int STARTING_EXP = 0;
	
	//ATTRIBUTI
	private String name;
	private ArrayList<Pokemon> listaPokemon;

	public Allenatore(String _name, ArrayList<Pokemon> _listaPokemon) {
		this.name = _name;
		for (int i=0; i<_listaPokemon.size(); i++)
			this.listaPokemon.add(i, _listaPokemon.get(i));
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Pokemon> getListaPokemon() {
		return listaPokemon;
	}


	public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
		this.listaPokemon = listaPokemon;
	}

}
