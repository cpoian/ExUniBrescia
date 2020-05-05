package it.unibs.ing.fp.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class CdMainUtility {

	private static final String CD_SUCCESSFULLY_REMOVED = "Cd successfully removed!";
	private static final String FOUND_A_REFERENCE = "Found a reference: ";
	private static final String ERROR_AUTHOR_NOT_FOUND = "Error, can't find this author!";
	private static final String INSERT_AUTHOR_NAME = "Insert author name: ";
	private static final String RANDOM_SONG_LIST = "Random song list: ";
	private static final String RANDOM_SONG = "Random song: ";
	private static final String ERROR_SONG_ALREADY_IN = "There is already 1 song with this name!";
	private static final String ERROR_SONG_NOT_FOUND = "Error, song not found!";
	private static final String MESSAGE__REMOVE_SONG = "Insert the song's title you want to remove";
	private static final String ERROR_CD_NOT_FOUND = "Can't find this cd!";
	private static final String MESSAGE_SELECT_ACTION = "Select action: ";
	private static final String MESSAGE_PROGRAM_CLOSED = "The program was closed successfully!";
	private static final String MESSAGE_CD_LIST_EMPTY = "Your must enter at least 1 cd!";
	private static final String ERROR_CD_TITLE = "Cd title already exists!";
	private static final String INSERT_CD_AUTHOR = "Insert Cd author: ";
	private static final String INSERT_CD_TITLE = "Insert Cd title: ";
	private static final String INSERT_SONG_MINUTES = "Insert song minutes: ";
	private static final String INSERT_REMAINING_SECONDS = "Insert remaining seconds of the song:  ";
	private static final String INSERT_SONG_TITLE = "Insert song title: ";
	private static final String INSERT_ARCHIVE_TITLE = "Start by your archive a title: ";
	
	private static final String[] MENU_METHODS = {"Insert new cd", 
												  "Insert new song", 
												  "Remove cd", 
												  "Remove song",
												  "Get a random song",
												  "Get a random list of songs",
												  "Check for a cd by the author",
												  "Check for a song by the title",
												  "Print a cd description",
												  "Print all the collection"};
	//1. Insert new cd
	//2. Insert new song
	//3. Remove cd
	//4. Remove song
	//5. Get a random song
	//6. Get a random list of songs
	//7. Check for a cd by the author
	//8. Check for a song by the title
	//9. Print a cd description
	//10. Print all the collection

	/**
	 *metodo statico per la creazione di un archivio
	 * @return restituisce un oggetto archivio, con la lista cd inizializzata vuota
	 */
	public static ArchivioCd createNewArchive() {
		ArchivioCd archive = new ArchivioCd();
		archive.setName(InputDati.leggiStringaNonVuota(INSERT_ARCHIVE_TITLE));
		return archive;
	}
	
	/**
	 * metodo statico per la creazione di un Cd e la sua aggiutna automatica al archivio
	 * @param archive deve essere dato in input per poterlo aggiungere
	 */
	public static void createAndAddACd(ArchivioCd archive) {
		String title;
		do {
			title = InputDati.leggiStringaNonVuota(INSERT_CD_TITLE);
			if (archive.contiene(title))
				System.out.println(ERROR_CD_TITLE);
		}while(archive.contiene(title));
		String author = InputDati.leggiStringaNonVuota(INSERT_CD_AUTHOR);
		archive.aggiungiCd(new Cd(title, author));
	}
	
	/**
	 * metodo statico per la creazione a video di un brano e la sua aggiunta in un cd 
	 * @param cd deve essere dato in input per poter "aggiungere" la canzone alla sua collezione
	 * @param archive deve essere dato in input per poter controllare che la canzone non sia già presente
	 */
	public static void createAndAddASong(Cd cd, ArchivioCd archive) {
		String title = InputDati.leggiStringaNonVuota(INSERT_SONG_TITLE);
		if (archive.checkArchiveForASongName(title) != null)
			System.out.println(ERROR_SONG_ALREADY_IN);
		else {
			int min = InputDati.leggiInteroPositivo(INSERT_SONG_MINUTES);
			int sec = InputDati.leggiInteroPositivo(INSERT_REMAINING_SECONDS);
			cd.aggiungiBrano(new Brano(title, min, sec));
		};
	}
	
	
	/**
	 * 1. Insert new cd
	 * 2. Insert new song
	 * 3. Remove cd
	 * 4. Remove song
	 * 5. Get a random song
	 * 6. Get a random list of songs
	 * 7. Check for a cd by the author
	 * 8. Check for a song by the title
	 * 9. Print a cd description
	 * 10. Print all the collection
	 * @param archive deve essere inserito in input per averlo a disposizione dei vari metodi
	 */
	public static void mainMenu(ArchivioCd archive) {
		MyMenu menu = new MyMenu(MESSAGE_SELECT_ACTION, MENU_METHODS);
		int option;
		Brano songToRemove;
		Cd cdAddSong;
		Cd cdToRemove;
		Brano randomSong;
		ArrayList<Brano> randomSongList = new ArrayList<Brano>();
		String authorToCheck;
		String songTitleToCheck;
		String cdTitleToPrintDescription;
		do {
			if (archive.getCdList().isEmpty()) {
				System.out.println(MESSAGE_CD_LIST_EMPTY);
				option = 1;
			}
			else 
				option = menu.scegli();
			
			switch(option) {
				case 1:
					CdMainUtility.createAndAddACd(archive);
					break;
				case 2:
					cdAddSong = archive.lookForCdName(InputDati.leggiStringaNonVuota(INSERT_CD_TITLE));
					if(cdAddSong == null)
						System.out.println(ERROR_CD_NOT_FOUND);
					else
						CdMainUtility.createAndAddASong(cdAddSong, archive);
					break;
				case 3:
					cdToRemove = archive.lookForCdName(InputDati.leggiStringaNonVuota(INSERT_CD_TITLE));
					if(cdToRemove == null)
						System.out.println(ERROR_CD_NOT_FOUND);
					else {
						archive.eliminaCd(cdToRemove.getTitle());
						System.out.println(CD_SUCCESSFULLY_REMOVED);
					}
					break;
				case 4:
					songToRemove = archive.checkArchiveForASongName(InputDati.leggiStringaNonVuota(MESSAGE__REMOVE_SONG));
					if(songToRemove == null)
						System.out.println(ERROR_SONG_NOT_FOUND);
					else
						archive.checkArchiveForACdByASong(songToRemove.getTitolo()).removeSong(songToRemove.getTitolo());
					break;
				case 5:
					randomSong = archive.getRandomSong();
					System.out.println(RANDOM_SONG + randomSong.toString());
					break;
				case 6:
					System.out.println(RANDOM_SONG_LIST);
					randomSongList.clear();
					randomSongList.addAll(archive.getRandomSongList());
					for (int i = 0; i < randomSongList.size(); i++)
						System.out.println(String.format("%d# %s", i+1, randomSongList.get(i).toString()));
					break;
				case 7:
					authorToCheck = InputDati.leggiStringaNonVuota(INSERT_AUTHOR_NAME);
					if (archive.checkArchiveForACdAuthor(authorToCheck) == null)
						System.out.println(ERROR_AUTHOR_NOT_FOUND);
					else {
						System.out.println(FOUND_A_REFERENCE);
						System.out.println(archive.checkArchiveForACdAuthor(authorToCheck).toString());
					}	
					break;
				case 8:
					songTitleToCheck = InputDati.leggiStringaNonVuota(INSERT_SONG_TITLE);
					if (archive.checkArchiveForACdByASong(songTitleToCheck) == null)
						System.out.println(ERROR_SONG_NOT_FOUND);
					else {
						System.out.println(FOUND_A_REFERENCE);
						System.out.println(archive.checkArchiveForACdByASong(songTitleToCheck).toString());
					}
					break;
				case 9:
					cdTitleToPrintDescription = InputDati.leggiStringaNonVuota(INSERT_CD_TITLE);
					if (archive.contiene(cdTitleToPrintDescription))
						archive.printACdCollection(cdTitleToPrintDescription);
					else
						System.out.println(ERROR_CD_NOT_FOUND);
					break;
				case 10:
					archive.printAllSongs();
					break;
				default:
					archive.printAllSongs();
					System.out.println(MESSAGE_PROGRAM_CLOSED);
					break;
			}
		}while(option != 0);
	}
}
