package it.unibs.ing.fp.puntirette;

public class Retta {
	private boolean verticale;
	private double coeffAngolare;
	private double offSet;
	
	private static final double EPSILON = 0.0000001;
	
	public Retta(boolean _verticale, double _coeffAngolare, double _offSet) {
		//super();
		this.verticale = _verticale;
		this.coeffAngolare = _coeffAngolare;
		this.offSet = _offSet;
	}
	public Retta(Punto p1, Punto p2) {
		if (p1.getX() == p2.getX()) {
			verticale = true;
			offSet = p1.getX();
		}
		else {
			verticale = false;
			coeffAngolare = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
			offSet = p2.getY() - coeffAngolare * p2.getX();
		}
	}
	@Override
	public String toString() {
		String equazione;
		if(verticale == true)
			equazione = "x = " + offSet;
		else if (coeffAngolare == 0)
			equazione = "y = " + offSet;
		else
			equazione = "y = " + coeffAngolare + "x + " + offSet;
		return equazione;
	}
	
	public boolean appartiene(Punto p) {
		boolean appartiene = false;
		
		if (verticale == true) {
			if (Math.abs(offSet - p.getX()) < EPSILON)
				appartiene = true;
		}
		else {
			double newY = coeffAngolare *p.getX() + offSet;
			if (Math.abs(newY - p.getY()) < EPSILON)
				appartiene = true;
		}	
		
		return appartiene;
	}
		
		
	}
	
