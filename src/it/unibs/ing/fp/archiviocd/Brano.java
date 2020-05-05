package it.unibs.ing.fp.archiviocd;

public class Brano {

	private String title;
	private int minutes;
	private int seconds;
	
	public Brano(String _title, int _minutes, int _seconds) {
		this.title = _title;
		this.minutes = _minutes;
		this.seconds = _seconds;
	}

	/**
	 * Stampa una stringa con in ordine:
	 * 1. titolo del brano
	 * 2. durata in questo formato [00:00]
	 */
	public String toString() {
		return String.format("%s [%02d:%02d] ", this.title, this.minutes, this.seconds);
	}
	

	//GETTERS AND SETTERS
	public String getTitolo() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
}
