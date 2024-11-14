import urnas.Urna;
import urnas.SalaVotacion;

public class PruebaSalaVotacion {
	public static void main(String[] args) {
		SalaVotacion sala1 = new SalaVotacion();
		
		sala1.votar(1, true);
		sala1.votar(1, true);
		System.out.println(sala1.resultado(1));
		System.out.println(sala1.resultado(2));
		
	}
}
