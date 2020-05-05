package it.unibs.ing.fp.tamagotchi;

import it.unibs.fp.mylib.MyMenu;

public class TamagotchiMain {
	
	private static final String BENVENUTI = String.format("Welcome to: %nTAMAGOTCHI The Game :)%nInizio del gioco in..."
														+ "%n3...%n2...%n1...%n");
	private static final String INSERISCI_LA_TUA_SCELTA = "Fai la tua scelta: ";
	private static final String[] TAMA_INPUT_ARRAY = {"BISCOTTI", "CAREZZE"};
	
	private static final int SCELTA_MENU_PER_USCIRE = 0;
	
	/**
	 * 1. viene stampato il messaggio di benvenuto
	 * 2. viene creato l'oggetto Tamagotchi
	 * 3. viene creato l'oggetto menu dalla classe MyMenu
	 * 4. viene effettuato un ciclo infinito dove si chiede all'utente una scelta tra 0, 1 e 2
	 * 	e in base ad essa si lanciano i metodi riceviBiscotti o riceviCarezze o si esce dal ciclo.
	 * 	Nel caso in cui il ciclo prosegue ad ogni iterazione verrà stampato un breve reseconto dello
	 * 	stato del Tamagotchi.
	 * 	All'interno del ciclo è presente anche un counter, che viene incrementato nel caso la scelta si ripeta 
	 * 	e ad ogni iterazione il counter viene sottratto al numero casuale estratto ogni volta
	 * 	Il counter si resetta quando si cambia scelta
	 * 	@author Catalin
	 * 5. stampa un resconto finale
	 * @param args array di stringhe 
	 */
	public static void main(String[] args) {

		System.out.println(BENVENUTI);
		Tamagotchi tama = TamagotchiMainUtility.tamagotchiCreation();
		MyMenu menu = new MyMenu(INSERISCI_LA_TUA_SCELTA, TAMA_INPUT_ARRAY);
		
		int scelta;
		int sceltaPrecedente = -1; 
		int counter = 0;
		
		for(;;) {
			switch (scelta = menu.scegli()) {
			case 1:
				tama.riceviBiscotti(Math.max(0,TamagotchiMainUtility.calcolaCasualeBiscottiOCarezze(scelta)-counter));
				break;
			case 2:
				tama.riceviCarezze(Math.max(0, TamagotchiMainUtility.calcolaCasualeBiscottiOCarezze(scelta)-counter));
				break;
			}
			
			if (sceltaPrecedente == scelta)
				counter++;
			else {
				sceltaPrecedente = scelta;
				counter = 0;
			}
			
			if (tama.sonoMorto() || scelta == SCELTA_MENU_PER_USCIRE)
				break;
			tama.printTamaSummary();
		}
		
		TamagotchiMainUtility.stampaFinale(tama);
	}
}
