package it.unibs.ing.fp.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;

//ciao
//ciao 2
public class ArchivioCd {
	
	private static final int SONG_LIST_SIZE = 2;
	private static final String MESSAGE_SONG_LIST_SIZE = "Insert song list size: ";
	
	private String title;
	private ArrayList<Cd> cdList;
	
	public ArchivioCd() {
		this.title = "Default Archive Name";
		this.cdList = new ArrayList<Cd>();
	}
	//ciao
	public int getNumeroCd() {
		return this.getCdList().size();
	}

	/**
	 * da il cd in input lo aggiunge in coda alla collezione del archivio
	 * @param cd deve essere da to in input l'oggetto per intero
	 */
	public void aggiungiCd(Cd cd) {
		this.getCdList().add(cd);
	}
	
	/**
	 * dato un titolo di un cd, lo rimuove dalla lista
	 * @param cdTitle titolo del cd da ricercare e rimuovere
	 */
	public void eliminaCd(String cdTitle) {
		this.getCdList().remove(this.lookForCdName(cdTitle));
	}
	
	/**
	 * metodo che controlla se un titolo è presente nella raccolta
	 * @param cdTitle titolo del cd da ricercare
	 * @return restituisce true se viene trovata una corrispondenza, false altrimenti
	 */
	public boolean contiene(String cdTitle) {
		if (this.lookForCdName(cdTitle) == null)
			return false;
		else
			return true;
	}
	
	/**
	 * fa la ricerca di un cd di un determinato autore
	 * non tiene conto degli spazi prima e dopo e del case
	 * @param cdAuthor il nome del autore da cercare
	 * @return restituisce l'oggetto se lo trova, altrimenti null
	 */
	public Cd checkArchiveForACdAuthor(String cdAuthor) {
		for(int i = 0; i < this.getCdList().size(); i++) 
			if(this.getCdList().get(i).getAuthor().strip().equalsIgnoreCase(cdAuthor.strip()))
				return this.getCdList().get(i);
		return null;
	}
	
	/**
	 * fa la ricerca di una canzone
	 * non tiene conto degli spazi prima e dopo e del case
	 * @param songTitle titolo della canzone
	 * @return l'oggetto se lo trova, altrimenti null
	 */
	public Brano checkArchiveForASongName(String songTitle) {
		for (int i = 0; i < this.getCdList().size(); i++)
			for (int j = 0; j < this.getCdList().get(i).getSongList().size(); j++) 
				if (this.getCdList().get(i).getSongList().get(j).getTitolo().strip().equalsIgnoreCase(songTitle.strip()))
					return this.getCdList().get(i).getSongList().get(j);
		return null;
			
	}
	
	/**
	 * metodo che dato fa la ricerca di un cd 
	 * @param songTitle deve essere dato in input per cercare il cd a cui appartiene
	 * @return restituisce l'oggetto cd cercato, oppure null
	 */
	public Cd checkArchiveForACdByASong(String songTitle) {
		for(int i = 0; i < this.getCdList().size(); i++)
			if(this.getCdList().get(i).contains(songTitle.strip()))
				return this.getCdList().get(i);
		return null;
	}
	
	/**
	 * estrae casualmente un brano dall'intera collezione
	 * @return restituisce un oggetto di tipo Brano
	 */
	public Brano getRandomSong() {
		return this.getCdList().get(EstrazioniCasuali.estraiIntero(0, this.getCdList().size()-1)).branoCasuale();
	}
	
	/**
	 * chiede a video la lunghezza della lista casuale di brani da estrarre
	 * viene impostato un minimo;
	 * @return restituisce un arraylist di tipo brano
	 */
	public ArrayList<Brano> getRandomSongList(){
		ArrayList<Brano> listaCasuale = new ArrayList<Brano>();
		int size = InputDati.leggiInteroConMinimo(MESSAGE_SONG_LIST_SIZE, SONG_LIST_SIZE);
		for(int i = 0; i < size; i++)
			listaCasuale.add(this.getRandomSong());
		return listaCasuale;
	}
	
	/**
	 * stampa la descrizione di un Cd dato in input
	 * @param cdTitle deve essere dato per poter trovare il Cd nella collezione
	 */
	public void printACdCollection(String cdTitle) {
		System.out.println(String.format("%s Collection%n---SONGS LIST---", this.lookForCdName(cdTitle).getTitle()));
		for (int i = 0; i < this.lookForCdName(cdTitle).getSongList().size(); i++) 
			System.out.println(String.format("%d# %s", i+1, this.lookForCdName(cdTitle).getSongList().get(i).toString()));
	}
	
	/**
	 * stampa la lista delle descrizioni dei cd + la desrizione di ogni canzone di ogni cd
	 */
	public void printAllSongs() {
		System.out.println(String.format("%s Collection: ", this.getTitle()));
		for (int i = 0; i < this.getCdList().size(); i++) 
			System.out.println(String.format("%d# %s ", i+1, this.getCdList().get(i).toString()));
	}
	
	/**
	 * metodo che dato un titolo di un cd, restituisce l'oggetto corrispondente 
	 * non tiene conto ne degli spazi aggiuntivi prima e dopo e neanche del case
	 * @param cdTitle deve essere una stringa contenente il nome da ricercare
	 * @return restituisce l'oggetto cd cercato se lo trova, altrimenti null
	 */
	public Cd lookForCdName(String cdTitle) {
		for(int i = 0; i < this.getCdList().size(); i++) 
			if(this.getCdList().get(i).getTitle().strip().equalsIgnoreCase(cdTitle.strip()))
				return this.getCdList().get(i);
		return null;
	}
	
	//GETTERS AND SETTERS
	public String getTitle() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public ArrayList<Cd> getCdList() {
		return cdList;
	}

	public void setCdList(ArrayList<Cd> cdList) {
		this.cdList = cdList;
	}
	
	
	

}
