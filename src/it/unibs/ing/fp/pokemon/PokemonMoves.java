package it.unibs.ing.fp.pokemon;

public enum PokemonMoves {

	BODYSLAM("NORMAL", "PHYSICAL", 85, 100),
	MEGAKICK("NORMAL", "PHYSICAL", 120,	75),
	MEGAPUNCH("NORMAL", "PHYSICAL", 80, 85),
	HYPERBEAM("NORMAL",	"SPECIAL", 150, 90);
	
	private PokemonAndMovesType type;
	private String damage;
	private int power;
	private int accuracy;
	
	private PokemonMoves(String type, String damage, int power, int accuracy) {
		this.type = PokemonAndMovesType.getType(type);
		this.damage = damage;
		this.power = power;
		this.accuracy = accuracy;
	}
	
	public static PokemonMoves[] pokemonMovesToArray () {
		int i = 0;
		PokemonMoves[] array = null;
		for(PokemonMoves p : values())
			array[i] = p;
		return array;
	}
}
