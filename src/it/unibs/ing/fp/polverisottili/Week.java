package it.unibs.ing.fp.polverisottili;

import allprojectsutility.MathMethods;
import it.unibs.fp.mylib.InputDati;

public class Week {
	
	private static final int AVERAGE_THRESHOLD = 50;
	private static final int MAX_THRESHOLD = 75;
	
	private static final String INSERT_DAY_VALUE = "#Insert day %d value: ";
	private static final String MESSAGE_INIT = "### %d, %d° week: ";
	private static final String MESSAGE_AVERAGE_OVER = String.format("The average of the measurements is too high, we have a problem!!!");
	private static final String MESSAGE_MAX_OVER = String.format("There was a day where max measurement was higher than the standart!!!");
	private static final String MESSAGE_PERFECT_WEEK = String.format("A good week, all values below standarts of pollution!");
	
	private int year;
	private int indexNumber;
	private double[] dayValue = new double[7];
	
	public Week(int year, int indexNumber) {
		this.year = year;
		this.indexNumber = indexNumber;
	}
	
	/**
	 * stampa la descrizione della settimana
	 * un messaggio positivo se nessun allarme è scattato
	 * altrimenti un messaggio negativo e dei messaggi per ogni tipo di allarme scattato
	 * @param week la settimana di riferimento
	 */
	public void printWeeksFeatures() {
		System.out.println(String.format(MESSAGE_INIT, this.getYear(), this.getIndexNumber()));
		if (this.maxNotExceeded() && this.averageNotExceeded())
			System.out.println(MESSAGE_PERFECT_WEEK);
		else {
			if (this.maxNotExceeded() == false)
				System.out.println(MESSAGE_MAX_OVER);
			if (this.averageNotExceeded() == false)
				System.out.println(MESSAGE_AVERAGE_OVER);
		}
	}

	/**
	 * metodo per permettere l'inserimento da parte del utente dei dati rilevati
	 */
	public void setWeeksMeasurements() {
		for(int i = 0; i< this.getDayValue().length; i++)
			this.getDayValue()[i] = InputDati.leggiDoubleConMinimo(String.format(INSERT_DAY_VALUE, i+1), 0);
	}
	
	/**
	 * metodo che controlla che il massimo non sia stato superato
	 * @return restituisce true se si è sotto la media, oppure false in caso contrario
	 */
	public boolean maxNotExceeded() {
		if (this.getMaxMeasurement()<= MAX_THRESHOLD)
			return true;
		else
			return false;
	}
	
	/**
	 * metodo che controlla che la media non sia stata superata
	 * @return restituisce true se si è sotto la media, oppure false in caso contrario
	 */
	public boolean averageNotExceeded() {
		if (this.getAverageMeasurement() <= AVERAGE_THRESHOLD)
			return true;
		else
			return false;
	}
	
	/**
	 * restiuisce il massivo valore rilevato durante la settimana
	 * @return un valore double corrispondente al massimo valore rilevato
	 */
	public double getMaxMeasurement() {
		double max = 0;
		for (int i = 0; i < this.getDayValue().length; i++) 
			max = MathMethods.calculateMax(max, this.getDayValue()[i]);
		return max;
	}
	
	/**
	 * calcola la media delle misurazioni durante la settimana
	 * @return restituisceu n valore con double con la media
	 */
	public double getAverageMeasurement() {
		return MathMethods.calculateAverage(this.getDayValue());
	}

	//GETTERS AND SETTERS
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public double[] getDayValue() {
		return dayValue;
	}

	public void setDayValue(double[] dayValue) {
		this.dayValue = dayValue;
	} 
	
	
	
}
