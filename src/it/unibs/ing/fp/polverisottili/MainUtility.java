package it.unibs.ing.fp.polverisottili;

public class MainUtility {


	private static final int AVERAGE_THRESHOLD = 75;
	private static final int MAX_THRESHOLD = 75;
	
	private static final String MESSAGE_INIT = "%d, %d° week: ";
	private static final String MESSAGE_AVERAGE_OVER = String.format("The average of the measurements is too high, we have a problem!!!");
	private static final String MESSAGE_MAX_OVER = String.format("There was a day where max measurement was higher than the standart!!!");
	private static final String MESSAGE_PERFECT_WEEK = String.format("A good week, all values below standarts of pollution!");

	public static void printWeeksFeatures(Week week, double max, double average) {
		System.out.println(String.format(MESSAGE_INIT, week.getYear(), week.getIndexNumber()));
		if (max <= MAX_THRESHOLD && average <= AVERAGE_THRESHOLD)
			System.out.println(MESSAGE_PERFECT_WEEK);
		else {
			if (max >= MAX_THRESHOLD)
				System.out.println(MESSAGE_MAX_OVER);
			if (average >= AVERAGE_THRESHOLD)
				System.out.println(MESSAGE_AVERAGE_OVER);
		}
	}
}
