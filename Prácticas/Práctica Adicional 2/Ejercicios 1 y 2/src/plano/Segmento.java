package plano;

public class Segmento {
	private Punto p1, p2;
	
	public Segmento() {
		this.p1 = new Punto(0, 0);
		this.p2 = new Punto(0, 0);
	}
	
	public Segmento(double x1, double y1, double x2, double y2) {
		p1.setAbscisa(x1);
		p1.setOrdenada(y1);
		p2.setAbscisa(x2);
		p2.setOrdenada(y2);
	}
	
	public Segmento(Punto p1, Punto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public double longitud() {
		return p1.distancia(p2);
	}
	
	public void desplazar(double a, double b) {
		p1.desplazar(a, b);
		p2.desplazar(a, b);
	}
	
	@Override 
	public String toString () {
		return "((" + p1.getAbscisa() + ", " + p1.getOrdenada() + "), (" + p2.getAbscisa() + ", " + p2.getOrdenada() + "))";
	}
	
}
