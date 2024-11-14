import bus.Parada;


public class PruebaParada {

	public static void main(String[] args) {
		String comp;
		Parada p1 = new Parada("Louis Pasteur", 36.71654, -4.47508);
		Parada p2 = new Parada("Paseo del Parque", 36.71884, -4.41910);
		Parada p3 = new Parada("Pedregalejo", 36.72219, -4.37708);
		System.out.println(p1);

		if (p1.distancia(p2) < p2.distancia(p3)) {
			comp = "menor";
		} else if (p1.distancia(p2) > p2.distancia(p3)) {
			comp = "mayor";
		} else {
			comp = "igual";
		}

		System.out.println("La distancia entre Louis Pasteur y Paseo del Parque es " + comp
				+ " que la distancia entre Paseo del Parque y Pedregalejo");

	}

}
