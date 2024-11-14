import urnas.Urna;

public class PruebaUrna {
	public static void main(String[] args) {
		Urna urna1 = new Urna();
		
		urna1.votar(false);
		urna1.votar(false);
		urna1.votar(true);
		urna1.votar(true);
		urna1.votar(true);
		
		urna1.resultado();
		urna1.toString();
		
		urna1.votar(false);
		urna1.votar(false);
		
		urna1.resultado();
		urna1.toString();
	}
}
