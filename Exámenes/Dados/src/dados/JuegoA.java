package dados;

import java.util.*;

public class JuegoA extends Juego{

	private int numDados;
	private int sumaBuscada;

	public JuegoA(int n, int suma) {
		if(n < 0 || n > suma || suma > 6*n ) {
			throw new IllegalArgumentException();
		}
		numDados = n;
		sumaBuscada = suma;
	}
	
	public int simula() {
		Cubilete c = new Cubilete(this.numDados);
		int suma = 0;
		int n = 0;
		
		while(suma != sumaBuscada) {
			Set<Dado> dados = c.tira();
			
			for(Dado dado : dados) {
				suma += dado.getCara();
			}
			n++;
		}
		
		return n;
	}
}
