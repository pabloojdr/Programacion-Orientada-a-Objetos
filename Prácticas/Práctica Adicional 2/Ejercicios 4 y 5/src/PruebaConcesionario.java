import prConcesionario.Coche;
import prConcesionario.Concesionario;
import prConcesionario.SelectorCoche;
import prConcesionario.SelectorPrecio;

public class PruebaConcesionario {
	public static void main(String[] args) {
		Concesionario cs1 = new Concesionario(5);
		SelectorCoche c = new SelectorPrecio(0, 500);

		cs1.addCoche("Tesla", 100);
		cs1.addCoche("Ferrari", 50);
		cs1.addCoche("Lamborghini", 454);
		cs1.addCoche("Citroen", 34);
		cs1.addCoche("Audi", 4235);

		System.out.println(cs1);
		
		System.out.println(cs1.seleccionar(c));
		
		
		System.out.println(cs1.cocheMasBarato());
	}
}
