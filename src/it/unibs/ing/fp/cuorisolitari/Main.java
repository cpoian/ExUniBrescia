package it.unibs.ing.fp.cuorisolitari;

//import it.unibs.fp.mylib.InputDati;;

public class Main {

	public static void main(String[] args) {
		
		CuoreSolitario pers1 = CuoreSolitarioCreazione.creaCuoreSolitario();
		CuoreSolitario pers2 = CuoreSolitarioCreazione.creaCuoreSolitario();

		System.out.println(pers1.toString(pers2));
	}

}
