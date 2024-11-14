package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceContador extends IndiceAbstracto {
	private SortedMap<String, Integer> indice;

	public IndiceContador() {
		super();		//Si no ponemos esta linea, no pasa nada. Java lo llama por defecto.
		indice = new TreeMap<String, Integer>();
	}

	@Override
	public void resolver(String delimitadores) {
		indice.clear();

		for (String frase : frases) {
			String[] palabras = frase.split(delimitadores);

			for (String palabra : palabras) {
				if (palabra.length() > 0) {
					palabra = palabra.toLowerCase();
					
					int n = indice.getOrDefault(palabra, 0); //si la palabra está, devuelve la posicion. Si no está, devuelve 0
					indice.put(palabra, ++n); //No funciona con n++
				}
			}
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for(String palabra : indice.keySet()) {
			pw.printf("%-10s %5d%n", palabra, indice.get(palabra));
		}
	}
}
