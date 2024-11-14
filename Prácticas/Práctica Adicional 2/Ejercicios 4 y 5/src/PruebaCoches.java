import prConcesionario.Coche;

public class PruebaCoches {
	public static void main(String [] args) {
		Coche c1 = new Coche("Tesla", 500);
		
		System.out.println(c1);
		Coche.setIVA(21);
		System.out.println(c1);
		
	}
}
