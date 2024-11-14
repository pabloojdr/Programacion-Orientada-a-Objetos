package indices;

import java.io.PrintWriter;
import java.util.*;

public abstract class IndiceAbstracto implements Indice {
	protected List<String> frases;
	
	public IndiceAbstracto() {
		frases = new ArrayList<String>(); //Una alternativa sería usar LinkedList
	}
	
	@Override
	public void agregarFrase(String frase) {
		frases.add(frase);
	}
	
	@Override
	public void presentarIndiceConsola() {
		PrintWriter pw = new PrintWriter(System.out, true);
		presentarIndice(pw);
	}
}
