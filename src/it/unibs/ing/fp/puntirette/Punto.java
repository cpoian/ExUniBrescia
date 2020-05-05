package it.unibs.ing.fp.puntirette;

public class Punto {

	private double x;
	private double y;
	
	public Punto (double _x, double _y) {
		this.x = _x;
		this.y = _y;
	}
	
	public double distanzaPunti(Punto p) {
		return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2));
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	boolean equals (Punto p) {
		boolean isEqual = false;
		if (this.x == p.x && this.y == p.y)
			isEqual = true;
		return isEqual;
	}
	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
}
