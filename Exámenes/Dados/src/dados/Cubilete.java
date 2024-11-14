package dados;

import java.util.*;

public class Cubilete {
	private List<Dado> cubilete;
	
	public Cubilete(int n) {
		cubilete = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			cubilete.add(new Dado());
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("El numero de dados tiene que ser mayor que cero");
		}
	}
	
	public Set<Dado> tira(){
		Set<Dado> c = new HashSet<>();
		
		for(Dado dado : cubilete) {
			dado.agita();
			c.add(dado);
		}
		
		return c;
	}
}
