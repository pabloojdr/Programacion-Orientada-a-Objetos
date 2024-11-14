package dados;

import java.util.*;

public abstract class Juego implements Simulacion {
	public Juego() {

	}

	public List<Integer> experimento(int numSim) {
		List<Integer> lista = new ArrayList<Integer>();

		if (numSim <= 0) {
			throw new IllegalArgumentException("El número de tiradas no puede ser igual o menor que 0");
		}

		for (int i = 0; i < numSim; i++) {
			lista.add(simula());
		}

		return lista;
	}

	public SortedMap<Integer, Integer> agrupa(List<Integer> list) {
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (Integer i : list) {
			int n = map.getOrDefault(i, 0);
			
			map.put(i, n+1);
		}
		return map;
	}
}
