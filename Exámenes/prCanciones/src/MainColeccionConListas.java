import java.util.ArrayList;
import canciones.Coleccion;
import canciones.ColeccionConListas;
import canciones.Estilo;

public class MainColeccionConListas {
	public static void main(String[] args) {
		Coleccion c1 = new Coleccion();
		ArrayList<String> inter1 = new ArrayList<String>();
		inter1.add("Aitana");
		inter1.add("Nicki Nicole");
		ArrayList<String> inter2 = new ArrayList<String>();
		inter2.add("The Weekend");
		inter2.add("Ariana Grande");
		
		ArrayList<String> inter3 = new ArrayList<String>();
		inter3.add("The Weekend");
		
		
		c1.anyadirCancion("Formentera", inter1, 207, Estilo.POP);
		c1.anyadirCancion("Save Your Tears", inter2, 237);
		c1.anyadirCancion("Blinding Lights", inter3, 340);
		
		System.out.println(c1);
	}
}
