import java.util.ArrayList;

import canciones.Coleccion;
import canciones.Estilo;

public class MainColeccion {
	public static void main(String[] args) {
		Coleccion c1 = new Coleccion();
		ArrayList<String> inter1 = new ArrayList<String>();
		inter1.add("Aitana");
		inter1.add("Nicki Nicole");
		ArrayList<String> inter2 = new ArrayList<String>();
		inter2.add("The Weekend");
		inter2.add("Ariana Grande");
		c1.anyadirCancion("Formentera", inter1, 207, Estilo.POP);
		c1.anyadirCancion("Save Your Tears", inter2, 237);

		System.out.println(c1);
		
		c1.borrarCancion("Formentera", inter1);
		System.out.println(c1);
	}
}

