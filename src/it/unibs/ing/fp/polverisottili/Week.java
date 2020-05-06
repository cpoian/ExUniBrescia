package it.unibs.ing.fp.polverisottili;

public class Week {
	
	private int year;
	private int indexNumber;
	private double[] dayValue = new double[7];
	
	public Week(int year, int indexNumber) {
		super();
		this.year = year;
		this.indexNumber = indexNumber;
	}

	//GETTERS AND SETTERS
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public double[] getDayValue() {
		return dayValue;
	}

	public void setDayValue(double[] dayValue) {
		this.dayValue = dayValue;
	} 
	
	
	
}
