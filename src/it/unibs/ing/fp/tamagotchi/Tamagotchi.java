package it.unibs.ing.fp.tamagotchi;


public class Tamagotchi {

	private static final double PERCENTUALE_DIMINUZIONE_SAZIETA = 0.5;
	private static final double PERCENTUALE_DIMINUZIONE_SODDISFAZIONE = 0.25;
	private static final double PERCENTUALE_PER_BISCOTTO = 0.1;
	
	private static final double MEDIA_PESO_SAZIETA = 2;//per la regola cibo = felicità
	private static final double MEDIA_PESO_SODDISFAZIONE = 1;
	
	private static final int SOGLIA_CONTENTO = 60;
	private static final int SOGLIA_FELICE = 80;
	
	private static final int MIN_SODDISFAZIONE = 30;
	//private static final int MAX_SODDISFAZIONE = 90;
	private static final int MAX_SAZIETA = 90;
	private static final int MIN_SAZIETA = 30;
	
	private static final int VALORE_MINIMO_SODDISFAZIONE_E_SAZIETA = 0;
	private static final int VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA = 100;
	private static final int MIN_VAL_DEATH= 0;
	
	public static final String ASTERISCHI = "*************************************************************************";
	public static final String LINEE = "-------------------------------------------------------------------------";
	private static final String PROMPT_SODDISFATTO_CON_NOME = "La soddisfazione attuale di %s è : %.2f";
	private static final String PROMPT_SAZIETA_CON_NOME = "La sazietà attuale di %s è : %.2f";
	private static final String PROMPT_TRISTE_CON_NOME = "%s è triste. :(";
	private static final String PROMPT_STATO_TAMAGOTCHI_NON_TRISTE_CON_NOME = "%s è %s";
	
	private static final String PROMPT_UN_PO_GIÙ_DI_MORALE = "un po' giù di morale";
	private static final String PROMPT_CONTENTO = "contento";
	private static final String PROMPT_FELICE = "felice";

	private String nome;
	private double soddisfazione;
	private double sazieta;
	
	/**
	 * Il costruttore della classe
	 * @author Catalin
	 * @param _nome ci deve essere fornito il nome del Tamagotchi
	 * @param _soddisfazione deve essere compreso tra 1 e 50
	 * @param _sazieta deve essere compreso tra 1 e 50
	 */
	public Tamagotchi (String _nome, double _soddisfazione, double _sazieta) {
		this.nome = _nome;
		this.soddisfazione = _soddisfazione;
		this.sazieta = _sazieta;
	}
	
	/**
	 * Nel caso la sazietà o la soddisfazione arrivino a 0 oppure la sazieta raggiunga il valore massimo 100,
	 * ci indica che il Tamagotchi è morto
	 * @return ci restituisce true se il Tamagotchi muore, altrimenti false.
	 */
	public boolean sonoMorto() {
		if (this.getSazieta() == MIN_VAL_DEATH || this.getSoddisfazione() == MIN_VAL_DEATH || this.getSazieta() == VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA)
			return true;
		else
			return false;
	}

	/**
	 * Nel caso la sazietà o la soddisfazione siano minori di 30 oppure che la sazietà superi 90,
	 * ci indica che il Tamagotchi è triste. 
	 * @return restituisce true se il Tamagotchi è triste, altrimenti false.
	 */
	public boolean sonoTriste() {
		
		if(this.getSoddisfazione() < MIN_SODDISFAZIONE || this.getSazieta() < MIN_SAZIETA || this.getSazieta() > MAX_SAZIETA)
			return true;
		else
			return false;
	}
	
	/**
	 * Fa la media ponderata dei valori di sazietà e soddisfazione e in base a questo resituisce una stringa
	 * con la stato del Tamagotchi, i valori sono stati pensato per seguire un "è" in una frase
	 * @return restituisce:
	 * "felice" se maggiore o uguale a 80
	 * "contento" se maggiore o uguale a 60
	 * "un po' giù di morale" negli altri casi
	 */
	public String statoTamagotchi() {
		double sommaBenessere = this.getSazieta()*MEDIA_PESO_SAZIETA+this.getSoddisfazione()*MEDIA_PESO_SODDISFAZIONE;
		double mediaBenessere = sommaBenessere/(MEDIA_PESO_SAZIETA+MEDIA_PESO_SODDISFAZIONE);
		String stato;
		if (mediaBenessere >=SOGLIA_FELICE)
			stato = PROMPT_FELICE;
		else if (mediaBenessere >=SOGLIA_CONTENTO)
			stato = PROMPT_CONTENTO;
		else 
			stato = PROMPT_UN_PO_GIÙ_DI_MORALE;
		return stato;
	}
	
	/**
	 * Un metodo che stampa:
	 * 1. valore di sazietà
	 * 2. valore di soddisfazione
	 * 3. stato del Tamagotchi
	 */
	public void printTamaSummary() {
		System.out.println(ASTERISCHI);
		System.out.println(String.format(PROMPT_SAZIETA_CON_NOME, this.getNome(), this.getSazieta()));
		System.out.println(String.format(PROMPT_SODDISFATTO_CON_NOME, this.getNome(), this.getSoddisfazione()));

		if (this.sonoTriste())
			System.out.println(String.format(PROMPT_TRISTE_CON_NOME, this.getNome()));
		else
			System.out.println(String.format(PROMPT_STATO_TAMAGOTCHI_NON_TRISTE_CON_NOME, this.getNome(), this.statoTamagotchi()));
		System.out.println(ASTERISCHI);
	}
	
	/**
	 * metodo che aumenta del 10% il valore di biscotti per ogni biscotto
	 * viene anche diminuita la soddisfazione della metà del numero dei biscotti
	 * @param num ci serve per sapere quanti biscotti sono stati estratti
	 */
	public void riceviBiscotti(int num) {
		
		for(int i = 0;i<num;i++)
			this.setSazieta(this.getSazieta() + this.getSazieta()*PERCENTUALE_PER_BISCOTTO);
		if (this.getSazieta() >= VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA) 
			this.setSazieta(VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA);
		
		this.setSoddisfazione(this.getSoddisfazione() - (num * PERCENTUALE_DIMINUZIONE_SODDISFAZIONE));
		if (this.getSoddisfazione()<VALORE_MINIMO_SODDISFAZIONE_E_SAZIETA)
			this.setSoddisfazione(VALORE_MINIMO_SODDISFAZIONE_E_SAZIETA);
	}
	
	/**
	 * metodo che aumenta del numero di carezze ricevuto
	 * viene anche diminuita la sazietà di un quarto del numero di carezze
	 * @param num ci serve per sapere quante carezze sono stati estratte
	 */
	public void riceviCarezze(int num) {
		
		this.setSoddisfazione(this.getSoddisfazione() + num);
		if (this.getSoddisfazione() > VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA)
			this.setSoddisfazione(VALORE_MASSIMO_SODDISFAZIONE_E_SAZIETA);
		
		this.setSazieta(this.getSazieta() - (num * PERCENTUALE_DIMINUZIONE_SAZIETA));
		if (this.getSazieta()<VALORE_MINIMO_SODDISFAZIONE_E_SAZIETA)
			this.setSazieta(VALORE_MINIMO_SODDISFAZIONE_E_SAZIETA);
		
	}
	
	/**
	 * getter di soddisfazione
	 * @author Catalin
	 * @return il valore di soddisfazione
	 */
	
	public double getSoddisfazione() {
		return soddisfazione;
	}

	/**
	 * getter di sazieta
	 * @author Catalin
	 * @return il valore di sazietà
	 */
	public double getSazieta() {
		return sazieta;
	}
	
	/**
	 * getter di nome
	 * @author Catalin
	 * @return nome del Tamagotchi
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * setter di soddisfazione
	 * @author Catalin
	 * @param soddisfazione il valore al quale dobbiamo settare la soddisfazione
	 */
	public void setSoddisfazione(double soddisfazione) {
		this.soddisfazione = soddisfazione;
	}

	/**
	 * setter di sazietà
	 * @author Catalin
	 * @param sazieta il valore al quale dobbiamo settare la sazietà
	 */
	public void setSazieta(double sazieta) {
		this.sazieta = sazieta;
	}
	
	/**
	 * setter di nome
	 * @author Catalin
	 * @param nome la stringa del nome che dobbiamo settare al Tamagotchi
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
