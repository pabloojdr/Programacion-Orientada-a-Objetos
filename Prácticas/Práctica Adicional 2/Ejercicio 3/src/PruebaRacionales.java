import prCalculos.NumeroRacional;

public class PruebaRacionales {
	public static void main(String[] args) {
		NumeroRacional a = new NumeroRacional(3, -66);
		
		System.out.println(a);
		System.out.println(a.getDenominador());
		
		System.out.println(a.mcd(3, 4));
		System.out.println(a.mcd(6, 8));
		System.out.println(a.mcd(9, 3));
	}
}
