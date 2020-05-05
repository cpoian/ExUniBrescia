package it.unibs.ing.fp.tamagotchi;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.NumeriCasuali;

public class TamagotchiMainUtility {
	
	private static final String PROMPT_INSERISCI_NOME = "Inserisci un nome per il tuo Tamagotchi: ";
	private static final String SODDISFAZIONE_INIZIALE = "Inserisci grado di soddisfazione iniziale: ";
	private static final String SAZIETA_INIZIALE = "Inserisci grado di sazietà iniziale: ";
	
	private static final int MIN_SODDISFAZIONE = 1;
	private static final int MAX_SODDISFAZIONE = 50;
	private static final int MIN_SAZIETA = 1;
	private static final int MAX_SAZIETA = 50;
	
	private static final int NUMERO_CASUALE_MINIMO_BISCOTTI = 1;
	private static final int NUMERO_CASUALE_MINIMO_CAREZZE= 1;
	private static final int NUMERO_CASUALE_MASSIMO_BISCOTTI = 5;
	private static final int NUMERO_CASUALE_MASSIMO_CAREZZE = 20;

	/**
	 * chiede all'utente il valore iniziale dei 3 attributi della classe Tamagotchi e fa un controllo 
	 * sulla correttezza dei valori iniziali sfruttanto i metodi della classe InputDati
	 * @author Catalin
	 * @return restituisce l'oggetto Tamagotchi inizializzato con le 3 variabili
	 */
	public static Tamagotchi tamagotchiCreation(){
		
		String nome = InputDati.leggiStringaNonVuota(PROMPT_INSERISCI_NOME);
		double soddisfazione = InputDati.leggiIntero(SODDISFAZIONE_INIZIALE, MIN_SODDISFAZIONE, MAX_SODDISFAZIONE);
		double sazieta = InputDati.leggiIntero(SAZIETA_INIZIALE, MIN_SAZIETA, MAX_SAZIETA);
		return new Tamagotchi(nome, soddisfazione, sazieta);
	}
	
	/**
	 * Fa una stampa finale dopo che il ciclo è stato concluso all'interno del main
	 * @author Catalin
	 * @param tama deve essere fornito per poter lavorare sul Tamagotchi oggetto
	 */
	public static void stampaFinale(Tamagotchi tama) {
		
		System.out.println(Tamagotchi.ASTERISCHI);
		System.out.println(Tamagotchi.LINEE);
		System.out.println("Il programma è stato terminato...");
		if (tama.sonoMorto())
			System.out.println(String.format("Un minuto di silenzio per %s :(", tama.getNome()));
		else
			System.out.println(String.format("Sei uscito premendo 0, %s è ancora vivo", tama.getNome()));
		System.out.println(Tamagotchi.LINEE);
		tama.printTamaSummary();
	}
	
	/**
	 * La classe sfrutta il metodo estraiIntero della classe InputDati, all'interno di uno switch che cambia 
	 * il valore massimale in base alla scelta dell'utente fornito dall'esterno
	 * @param scelta può essere solo 1 oppure 2 in questo caso
	 * @return restituisce un numero il numero casuale estratto
	 */
	public static int calcolaCasualeBiscottiOCarezze(int scelta) {
		
		int num = 0;
		switch(scelta) {
		case 1:
			num = NumeriCasuali.estraiIntero(NUMERO_CASUALE_MINIMO_BISCOTTI, NUMERO_CASUALE_MASSIMO_BISCOTTI);
			break;
		case 2:
			num = NumeriCasuali.estraiIntero(NUMERO_CASUALE_MINIMO_CAREZZE, NUMERO_CASUALE_MASSIMO_CAREZZE);
			break;
		}
		
		System.out.println("E' stato estratto il numero: " + num);
		return num;
	}
	
}
