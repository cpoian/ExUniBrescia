package it.unibs.ing.fp.pokemon;

public enum Pokemon {
	//NOME(N°, "TYPE", LEVEL, PS, ATK, DIF, VEL, ATK SP, DIF SP, EXP, MOVE1, MOVE2, MOVE3, MOVE4)
	VENUSAUR(3, "GRASS", 80, 82, 83, 80, 100, 100),
	CHARIZARD(6, "FIRE", 78, 84, 78, 100, 85, 85),
	BLASTOISE(9, "WATER", 79, 83, 100, 78, 85, 85),
	BUTTERFLEE(12, "BUG", 60, 45, 50, 70, 80, 80),
	PIDGEOT(18, "FLYING", 83, 80, 75, 91, 70, 70),
	RATICATE(20, "NORMAL", 55, 81, 60, 97, 50, 50),
	PIKACHU(25, "ELECTRIC", 35, 55, 30, 90, 50, 50),
	GENGAR(94, "GHOST", 60, 65, 60, 110, 130, 130),
	DRAGONITE(149, "DRAGON", 91, 134, 95, 80, 100, 100),
	MEWTWO(150, "PSYCHIC", 106, 110, 90, 130, 154, 154);

	private int pokedexNumber;
	private PokemonAndMovesType type;
	private int level;
	private int healthPoints;
	private int attack;
	private int defense;
	private int specialAttack;
	private int specialDefence;
	private int velocity;
	private int experience;
	private PokemonMoves[] moves;
	
	private Pokemon(int n, String type, int hp, int atk, int dif, int vel, int atkSp, int difSp) {
		this.pokedexNumber = n;
		this.type = PokemonAndMovesType.getType(type);
		this.level = Allenatore.STARTING_LEVEL;
		this.healthPoints = hp;
		this.attack = atk;
		this.defense = dif;
		this.specialAttack = atkSp;
		this.specialDefence = difSp;
		this.velocity = vel;
		this.experience = Allenatore.STARTING_EXP;
		this.moves = PokemonMoves.pokemonMovesToArray();
		
	}

	public int getPokedexNumber() {
		return pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public PokemonAndMovesType getType() {
		return type;
	}

	public void setType(PokemonAndMovesType type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefence() {
		return specialDefence;
	}

	public void setSpecialDefence(int specialDefence) {
		this.specialDefence = specialDefence;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public PokemonMoves[] getMoves() {
		return moves;
	}

	public void setMoves(PokemonMoves[] moves) {
		this.moves = moves;
	}
	
	
}
