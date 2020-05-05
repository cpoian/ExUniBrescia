package it.unibs.ing.fp.archiviocd;

public class CdMain {

	private static final String WELCOME_MESSAGE = "Welcome to the my first Cd archive database!";

	public static void main(String[] args) {
		//lascio le inizializzazione se dovessero servire
//		Brano a = new Brano("Brano1", 4, 46);
//		Brano b = new Brano("Brano2", 4, 46);
//		Brano c = new Brano("Brano3", 4, 46);
//		Brano d = new Brano("Brano4", 4, 46);
//		Brano e = new Brano("Brano5", 4, 46);
//		Brano f = new Brano("Brano6", 4, 46);
//		Brano g = new Brano("Brano7", 4, 46);
//		Brano h = new Brano("Brano8", 4, 46);
//		Brano i = new Brano("Brano9", 4, 46);
//		
//		Cd cd1 = new Cd("Cd1", "Autore1");
//		Cd cd2 = new Cd("Cd2", "Autore2");
//		Cd cd3 = new Cd("Cd3", "Autore3");
//		
//		cd1.getSongList().add(a);
//		cd1.getSongList().add(b);
//		cd1.getSongList().add(c);
//		cd2.getSongList().add(d);
//		cd2.getSongList().add(e);
//		cd2.getSongList().add(f);
//		cd3.getSongList().add(g);
//		cd3.getSongList().add(h);
//		cd3.getSongList().add(i);
//		
//		ArchivioCd archivio = new ArchivioCd();
//		archivio.aggiungiCd(cd1);
//		archivio.aggiungiCd(cd2);
//		archivio.aggiungiCd(cd3);
		
		ArchivioCd archive = CdMainUtility.createNewArchive();
		
		System.out.println(WELCOME_MESSAGE);
		CdMainUtility.mainMenu(archive);
	
	}
}
