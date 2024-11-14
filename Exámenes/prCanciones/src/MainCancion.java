import java.util.ArrayList;
import canciones.Cancion;
import canciones.Estilo;

public class MainCancion {
	public static void main(String[] args) {
		ArrayList<String> cancion1 = new ArrayList<String>();
		cancion1.add("Ana Mena");
		ArrayList<String> cancion2 = new ArrayList<String>();
		cancion2.add("Aitana");
		cancion2.add("Nicki Nicole");
		
		Cancion c1 = new Cancion("Musica Ligera", cancion1, 235);
		Cancion c2 = new Cancion("Formentera", cancion2, 207, Estilo.POP);
		
		System.out.println(c1);
		System.out.println(c2);
	}
}
