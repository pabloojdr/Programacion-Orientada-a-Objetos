import plano.Punto;

public class PruebaPunto {
	public static void main(String[] arg) {
		Punto p = new Punto(0, 0);
		
		System.out.println(p);
		p.setAbscisa(9);
		p.setOrdenada(6);
		System.out.println(p);
		p.desplazar(-5, -3);
		System.out.println(p);
		System.out.println(p.distancia(new Punto(2, 3)));
	}
}
