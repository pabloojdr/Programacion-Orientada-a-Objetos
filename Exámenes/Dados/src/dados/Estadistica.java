package dados;

import java.util.*;

public class Estadistica {
	private SortedMap<Integer, Integer> experimentos;

	public Estadistica(SortedMap<Integer, Integer> e) {
		experimentos = new TreeMap<>(e);
	}

	public double media() {
		Set<Integer> k = experimentos.keySet();
		double sum = 0;
		double div = 0;
		for (Integer i : k) {
			sum += (i * experimentos.get(i));
			div += experimentos.get(i);
		}

		return sum / div;
	}

	public Set<Integer> moda() {
		Set<Integer> moda = new TreeSet<>();
		int maxTiradas = (new TreeSet<Integer>(experimentos.values())).last();
		for (Integer i : experimentos.keySet()) {
			if (experimentos.get(i) == maxTiradas)
				moda.add(i);
		}
		return moda;
	}

	public int mediana() {
		List<Integer> lista = new ArrayList<>();

		for (Integer i : experimentos.keySet()) {
			for (int j = 1; j <= experimentos.get(i); j++) {
				lista.add(i);
			}
		}

		int pos = lista.size() % 2 == 0 ? lista.size() / 2 : (lista.size() - 1) / 2;

		return lista.get(pos);
	}
}
