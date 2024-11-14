package dados;

import java.util.*;

public class JuegoB extends Juego {
	private int numDados;
	private int numSeises;
	
	public JuegoB(int n, int numS) {
		if(n <= 0 || numS <= 0) {
			throw new IllegalArgumentException("El número de dados y el de seises no puede ser menor o igual a cero");
		}
		
		numDados = n;
		numSeises = numS;
	}
	
	public int simula() {
		Cubilete c = new Cubilete(numDados);
		int cont = 0;
		int veces = 0;
		
		while(cont < numSeises) {
			Set<Dado> dados = c.tira();
			
			for(Dado dado : dados) {
				if(dado.getCara() == 6) {
					cont++;
				}
			}
			veces++;
		}
		
		return veces;
	}
}
