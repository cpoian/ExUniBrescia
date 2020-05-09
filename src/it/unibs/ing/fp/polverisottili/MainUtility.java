package it.unibs.ing.fp.polverisottili;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainUtility {


	private static final int MAX_INDEX_NUMBER = 53;
	private static final int MIN_INDEX_NUMBER = 1;
	private static final int MAX_YEAR = 2020;
	private static final int MIN_YEAR = 1950;
	
	private static final String INSERT_A_WEEK_S_YEAR = "Insert a week's year: ";
	private static final String INSERT_WEEK_S_INDEX_NUMBER = "Insert week's index number (1-53): ";
	private static final String INSERT_ACTION = "Insert action: ";
	
	private static final String[] menuOptions = {"Insert a week's values"};

	/**
	 * metodo del menu di sistema
	 * 1. crea un arraylist di tipo Week
	 * 2. inizializza il menu
	 * 3. (SE), la scelta è uguale a 1 crea una settimana chiedendo i dati in input + 
	 * + chiede il valori da registrare nelle misurazione
	 * 4. continua a chiedere se si vogliono aggiungere altre settimane
	 * 5 quando si esce, stampa i dettagli di ogni settimana con evventuali allarmi
	 */
	public static void mainMenu() {
		ArrayList<Week> weekList = new ArrayList<Week>();
		MyMenu menu = new MyMenu(INSERT_ACTION,menuOptions);
		int scelta;
		int index = 0;
		do {
			scelta = menu.scegli();
			if (scelta == 1) {
				weekList.add(MainUtility.inizializeAWeek());
				weekList.get(index).setWeeksMeasurements();
				index++;
			}
		}while (scelta != 0);
		System.out.println();
		MainUtility.printAllWeeksFromArrayList(weekList);
	}
	
	/**
	 * stampa i dettagli di ogni settimana di una arraylist di tipo Week
	 * @param list la lista delle settimane da stampare
	 */
	public static void printAllWeeksFromArrayList(ArrayList<Week> list) {
		for (int i = 0; i < list.size(); i++)
			list.get(i).printWeeksFeatures();
	}
	
	/**
	 * metodo che inzializza una settimana chiedendoli in input all'utente
	 * @return restituisce un oggetto di tipo Week
	 */
	public static Week inizializeAWeek() {
		int year = InputDati.leggiIntero(INSERT_A_WEEK_S_YEAR, MIN_YEAR, MAX_YEAR);
		int indexNumber = InputDati.leggiIntero(INSERT_WEEK_S_INDEX_NUMBER, MIN_INDEX_NUMBER, MAX_INDEX_NUMBER);
		return new Week(year, indexNumber);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
