package urnas;

public class SalaVotacion {
	private Urna urna1, urna2;
	
	public SalaVotacion(Urna urna1, Urna urna2) {
		this.urna1 = urna1;
		this.urna2 = urna2; 
	}
	
	public SalaVotacion() {
		this.urna1 = new Urna();
		this.urna2 = new Urna();
	}
	
	public void votar(int num_urna, boolean votillo) {
		if(num_urna == 1)
			urna1.votar(votillo);
			
		else if(num_urna == 2)
			urna2.votar(votillo);
		
		else{
			throw new RuntimeException("El numero de urna tiene que ser 1 o 2");
		}
	}
	
	public boolean resultado(int num_urna) {
		boolean resultado = false;
		if(num_urna == 1)
			resultado = urna1.resultado();
		
		if(num_urna == 2)
			resultado = urna2.resultado();
		
		return resultado;
	}
}
	