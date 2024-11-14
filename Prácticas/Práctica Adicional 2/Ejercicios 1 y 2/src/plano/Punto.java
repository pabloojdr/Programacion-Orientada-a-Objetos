package plano;

public class Punto {
	private double abs;
	private double ord;
	
	public Punto() {
		this.abs = 0;
		this.ord = 0;
	}
	
	public Punto(double abs, double ord) {
		this.abs = abs;
		this.ord = ord;
	}
	
	public double getAbscisa() {
		return abs;
	}
	
	public double getOrdenada() {
		return ord;
	}
	
	public void setAbscisa(double a) {
		abs = a;
	}
	
	public void setOrdenada(double a){
		ord = a;
	}
	
	public void desplazar(double a, double b) {
		abs += a;
		ord += b;
	}
	
	public double distancia(Punto o) {
		return Math.hypot(abs - o.getAbscisa(), ord - o.getOrdenada());
	}
	
	@Override
	
	public String toString() {
		return "(" + this.getAbscisa() + ", " + this.getOrdenada() + ")";
	}
}
