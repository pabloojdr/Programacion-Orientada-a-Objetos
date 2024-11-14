import plano.Punto;
import plano.Segmento;

public class PruebaSegmentos {
	public static void main(String[] args) {

		Punto p1 = new Punto(1, 3);
		Punto p2 = new Punto(2, 5);

		Segmento sg = new Segmento(p1, p2);

		System.out.println(sg);

		sg.desplazar(3, 4);
		System.out.println(sg);

		System.out.println(sg.longitud());
		
	}
}
