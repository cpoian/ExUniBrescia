package it.unibs.ing.fp.pokemon;

public enum PokemonAndMovesType {

	BUG, DRAGON, ELECTRIC, FIGHTING, FIRE, FLYING, 
	GHOST, GRASS, GROUND, ICE, NORMAL, POISON, PSYCHIC, ROCK, WATER;
	
	public static PokemonAndMovesType getType(String type) {
		for(PokemonAndMovesType list : values()) 
			if (list.toString().equalsIgnoreCase(type))
				return list;
		return null;
			
	}
}
