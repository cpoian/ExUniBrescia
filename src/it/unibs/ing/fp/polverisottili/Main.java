package it.unibs.ing.fp.polverisottili;

public class Main {

	private static final String MESSAGE_STARTING = "Polveri sottili exercise, starting...";
	private static final String MESSAGE_FINAL = String.format("%n%nProgram successfully closing!");

	public static void main(String[] args) {
		System.out.println(MESSAGE_STARTING);
		
		MainUtility.mainMenu();
		
		System.out.println(MESSAGE_FINAL);
		
	}

}
