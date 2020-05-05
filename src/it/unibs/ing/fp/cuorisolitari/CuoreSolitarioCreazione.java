package it.unibs.ing.fp.cuorisolitari;
import it.unibs.fp.mylib.InputDati;

public class CuoreSolitarioCreazione {
	
	private static final String ERRORE_PSEUDONIMO = "Inserire uno pseudonimo!!!";
	private static final String ERRORE_SESSO = "Inserire M oppure F!!!";
	private static final String ERRORE_STRINGA_NON_SEGNO_ZODIACALE = "La stringa inserita non corrisponde a "
																   + "nessuno segno zodiacale!!!";
	private static final String ERRORE_SEGNO_IDEALE_UGUALE_A_SEGNO_PROPRIO = "Il segno zodiacale ideale deve "
																		   + "essere diverso dal proprio";
	private static final int MAGGIORENNE = 18;
	private static final int OVER_ETA = 120;
	private static final String[] SEGNO_ZODIACALE_ARRAY = new String[] {"ARIETE", "TORO", "GEMELLI", "CANCRO", "LEONE", "VERGINE", 
	                                                  "BILANCIA", "SCORPIONE", "SAGITTARIO", "CAPRICORNO", "ACQUARIO", "PESCI"};
	
	public static CuoreSolitario creaCuoreSolitario(){
		CuoreSolitario pers = new CuoreSolitario();
		
		leggiPseudonimo(pers);
		leggiSesso(pers);
		leggiEta(pers);
		leggiSegnoProprio(pers);
		leggiSegnoIdeale(pers);
		
		return pers;
	}
	
	public static void leggiPseudonimo(CuoreSolitario pers) {
		String pseudonimo = null;
		
		do {
			pseudonimo = InputDati.leggiStringaNonVuota("Inserire lo pseudonimo: ");
			if (pseudonimo == null || pseudonimo.isEmpty())
				System.out.println(ERRORE_PSEUDONIMO);
		}while(pseudonimo == null || pseudonimo.isEmpty());
		
		pers.setPseudonimo(pseudonimo);
	}
	
	/************************************************************************************
	 * @leggiSesso																		*
	 * prende il valore inserito dal utente e lo trasforma in maiuscolo					*
	 * dopo di che tramite uno switch controlla che si M oppure F						*
	 * nel caso non si inserisca nessuno dei 2, da un messaggio di errore e ritenta		*
	 ************************************************************************************/
	
	public static void leggiSesso(CuoreSolitario pers) {
		Sesso sesso = null;
		String leggiStringaSesso = "";
		
		do {
			leggiStringaSesso = InputDati.leggiStringaNonVuota("Inserire il sesso di " + pers.getPseudonimo() + " (M/F): ");
			leggiStringaSesso = leggiStringaSesso.toUpperCase();
			switch (leggiStringaSesso) {
			case "M": 
				sesso = Sesso.M;
				break;
			case "F":
				sesso = Sesso.F;
				break;
			default:
				System.out.println(ERRORE_SESSO);
				break;
			}
		}while(sesso == null);
		pers.setSesso(sesso);
	}
	
	/********************************************************************************
	 * @leggiEta																	*
	 * controlla che l'età sia compresa tra le 2 costanti:							*
	 * @MAGGIORENNE <= @eta <= @OVER_ETA                               				*
	 ********************************************************************************/
	
	public static void leggiEta(CuoreSolitario pers) {

		int eta = InputDati.leggiIntero("Età: ", MAGGIORENNE, OVER_ETA);
		
		pers.setEta(eta);
	}
	
	/********************************************************************************************************************
	 * @ leggiSegnoProprio 																								*
	 * controlla che segno zodiacale inserito dal utente sia presente all'interno del array @SEGNO_ZODIACALE_ARRAY		*
	 * nel caso non lo fosse, da un messaggio di errore e fa reinserire il segno zodiacale								*
	 ********************************************************************************************************************/
	
	public static void leggiSegnoProprio(CuoreSolitario pers) {
		String segnoZodiacale = "";
		String leggiStringaSegno = "";
		
		do {
			leggiStringaSegno = InputDati.leggiStringaNonVuota("Inserire il segno zodiacale personale di " + pers.getPseudonimo() +": ");
			leggiStringaSegno = leggiStringaSegno.toUpperCase();
			
			for(int i = 0; i < SEGNO_ZODIACALE_ARRAY.length; i++)
				if(leggiStringaSegno.equals(SEGNO_ZODIACALE_ARRAY[i])) {
					segnoZodiacale = SEGNO_ZODIACALE_ARRAY[i];
				}
			if (segnoZodiacale.isEmpty())
				System.out.println(ERRORE_STRINGA_NON_SEGNO_ZODIACALE);
		}while (segnoZodiacale.isEmpty());
		
		pers.setSegnoProprio(segnoZodiacale);
	}
	
	/****************************************************************************************************************************
	 * @ leggiSegnoIdeale																										*
	 * controlla che segno zodiacale ideale inserito dal utente sia presente all'interno del array @SEGNO_ZODIACALE_ARRAY		*
	 * nel caso non lo fosse, da un messaggio di errore e fa reinserire il segno zodiacale										*
	 * fa un controllo anche che non sia uguale al proprio segno zodiacale														*
	 ****************************************************************************************************************************/
	
	public static void leggiSegnoIdeale(CuoreSolitario pers) {
		String segnoZodiacale = "";
		String leggiStringaSegno = "";
		
		do {
			leggiStringaSegno = InputDati.leggiStringaNonVuota("Inserire il segno zodiacale ideale di " + pers.getPseudonimo() +": ");
			leggiStringaSegno = leggiStringaSegno.toUpperCase();
			
			for(int i = 0; i < SEGNO_ZODIACALE_ARRAY.length; i++)
				if(leggiStringaSegno.equals(SEGNO_ZODIACALE_ARRAY[i])) {
					segnoZodiacale = SEGNO_ZODIACALE_ARRAY[i];
				}
			if (segnoZodiacale.equalsIgnoreCase(pers.getSegnoProprio())) {
				System.out.println(ERRORE_SEGNO_IDEALE_UGUALE_A_SEGNO_PROPRIO);
				segnoZodiacale = "";
			}
			if (segnoZodiacale.isEmpty())
				System.out.println(ERRORE_STRINGA_NON_SEGNO_ZODIACALE);
		}while (segnoZodiacale.isEmpty());
		
		pers.setSegnoIdeale(segnoZodiacale);
	}
	
	
}
