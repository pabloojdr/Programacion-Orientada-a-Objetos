package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto {
	private SortedMap<String, Set<Integer>> indice;
	
	public IndiceLineas() {
		super();
		indice = new TreeMap<String, Set<Integer>>();
	}
	
	@Override
	public void resolver(String delimitadores) {
		
		for(int numLin = 0; numLin < frases.size(); numLin++) {
			String palabras[] = frases.get(numLin).split(delimitadores);
			
			for(String palabra : palabras) {
				if(palabra.length() > 0) {
					palabra = palabra.toLowerCase();
					
					Set<Integer> lineas = indice.getOrDefault(palabra, new TreeSet<Integer>());
					
					lineas.add(numLin+1);
					indice.put(palabra, lineas);
				}
			}
		}
	}
	
	/*
	@Override
	public void presentarIndice(PrintWriter pw) {
		for(String palabra : indice.keySet()) {
			pw.printf("%-15s", palabra);
			pw.println("/t" + indice.get(palabra));
		}
	}
	
	*/
	
	@Override
	public void presentarIndice(PrintWriter pw) {
		for(String palabra : indice.keySet()) {
			StringJoiner sj = new StringJoiner(",", "<", ">");
			Set<Integer> li = indice.get(palabra); 
			
			for(Integer i : li) {
				sj.add(Integer.toString(i));
				
				pw.printf("%-10s%-20s%n", palabra, sj);
			}
		}
	}
}
