package it.unibs.ing.fp.polverisottili;

import allprojectsutility.MathMethods;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	private static final String INSERT_DAY_VALUE = "#Insert day %d value: ";
	private static final String INSERT_ACTION = "Insert action: ";
	private static final String[] menuOptions = {"Insert a week's values"};
	
	public static void main(String[] args) {
		
		Week week = new Week(2020, 1);
		
		MyMenu menu = new MyMenu(INSERT_ACTION,menuOptions);
		int scelta;
		
		do {
			scelta = menu.scegli();
			double max = 0;
			for (int i = 0; i < week.getDayValue().length; i++) {
				week.getDayValue()[i] = InputDati.leggiDoubleConMinimo(String.format(INSERT_DAY_VALUE, i+1), 0);
				max = MathMethods.calculateMax(max, week.getDayValue()[i]);
			}
			double average = MathMethods.calculateAverage(week.getDayValue());
			
			MainUtility.printWeeksFeatures(week, max, average);
				
		}while (scelta != 0);
		
		
	}

}
