package it.unibs.ing.fp.puntirette;
import it.unibs.fp.mylib.*;

//Si sviluppi un programma che svolge i seguenti compiti (da realizzare incrementalmente):
//	1) richiede due coppie di numeri (le coordinate di due punti in un piano) e 
//	presenta la distanza tra i due punti 
//	2) esegue il punto 1 e presenta anche l’equazione della retta che passa per i due punti
//	3) esegue il punto 2, quindi richiede le coordinate di un terzo punto e verifica se 
//	il terzo punto e' allineato con i primi due

public class Main {

	public static Punto creaPunto(String descrizionePunto) {
		double x = InputDati.leggiDouble(descrizionePunto + ", inserisci x: ");
		double y = InputDati.leggiDouble(descrizionePunto + ", inserisci y: ");
		return new Punto (x, y);
	}
	
	public static void main(String[] args) {
		
		Punto p1 = creaPunto("Punto 1");
		Punto p2 = creaPunto("Punto 2");
		
		double distanza = p1.distanzaPunti(p2);
		System.out.println("La distanza tra i 2 punti è: " + distanza);
		
		if (p1.equals(p2))
			System.out.println("I 2 punti sono coincidenti, ci sono infinie rette passanti per un punto!");
		else {
			Retta r = new Retta (p1, p2);
			System.out.println("L'equazione della retta passante per i 2 punti è : " + r.toString());
			
			Punto p3 = creaPunto("Punto 3");
			
			if (r.appartiene(p3) == true)
				System.out.println("Il punto appartiene alla retta!");
			else
				System.out.println("Il punto non appartiene alla retta!");
		}
		
		
		
		
	}

}
