package it.unibs.ing.fp.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Cd {

	private String title;
	private String author;
	private ArrayList<Brano> songList;
	
	public Cd(String title, String author) {
		this.title = title;
		this.author = author;
		this.songList = new ArrayList<Brano>();
	}
	/**
	 * Stampa una stringa con in ordine:
	 * 1. il titolo del cd
	 * 2. l'autore del cd
	 * 3. la lista di tutti i brani
	 */
	public String toString() {
		String s = String.format("Titolo: %s, Autore: %s, Lista dei brani:", this.getTitle(), this.getAuthor());
		for (int i = 0;i<this.getSongList().size();i++) {
			s = s.concat(String.format("%n	%d: %s", i+1,this.getSongList().get(i).toString()));
		}		
		return s;
	}
	
	/**
	 * permette di aggiungere un brano alla collezione di questo cd
	 * @param b deve essere di tipo Brano
	 */
	public void aggiungiBrano(Brano b) {
		this.getSongList().add(b);
	}
	
	/**
	 * metodo che rimuove dalla lista una canzone
	 * @param songName il nome della canzone da rimuovere
	 */
	public void removeSong(String songName) {
		this.getSongList().remove(this.getSong(songName));
	}
	
	/**
	 * il metodo prende in input una stringa e se corrisponde al nome di un brano, restituisce l'oggetto Brano iesimo
	 * NON è case sensitive
	 * è consigliato usare il metodo boolean contains per vedere se effettivamente la stringa corrisponde,
	 * così da evitare il caso null
	 * @param songName la stringa del titolo da cercare
	 * @return restituisce il brano se lo trova oppure null nle caso non trovi nulla
	 */
	public Brano getSong(String songName) {
		for (int i = 0; i< this.getSongList().size(); i++)
			if (songName.equalsIgnoreCase(this.getSongList().get(i).getTitolo()))
				return this.getSongList().get(i);
		return null;
	}
	
	/**
	 * estrae un brano casuale dall collezione
	 * @return restituisce il brano casuale estratto
	 */
	public Brano branoCasuale() {
		return this.getSongList().get(EstrazioniCasuali.estraiIntero(0, this.getSongList().size()-1));
	}
	
	/**
	 * metodo booleano per controllare se data un stringa in input essa corrisponde al titolo di una brano nella collezione
	 * @param songName la stringa di titolo ricercato
	 * @return restituisce true se trova una corrispondenza, o false se non trova nulla
	 */
	public boolean contains(String songName) {
		for(int i = 0; i<this.songList.size();i++)
			if (songName.equalsIgnoreCase(this.getSongList().get(i).getTitolo()))
				return true;
		return false;
	}
	
	/**
	 * controlla se la stringa in ingresso corrisponde al titolo del CD
	 * NON è case sensitive
	 * @param _string la stringa dela titolo richiesto
	 * @return restituisce true se corrisponde e false se non corrisponde
	 */
	public boolean haTitolo(String _string) {
		return (this.title.equalsIgnoreCase(_string));
	}
	
	//GETTERS AND SETTERS
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public ArrayList<Brano> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Brano> songList) {
		this.songList = songList;
	}
	
	
	
	
	
}
