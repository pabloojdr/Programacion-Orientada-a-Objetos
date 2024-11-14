//Campoy Fernández, Pablo Julián
//Doble grado en ingeniería informática y matemáticas (Grupo A)

package parrillatv;

import java.util.*;

public class ProgramasCortos implements SugerenciasTV {
	private int durMaxima;

	public ProgramasCortos(int dur) {
		durMaxima = dur;
	}

	public SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs) {
		SortedSet<ProgramaTV> programasord = new TreeSet<>(new OrdenAlternativoTV());

		for (ProgramaTV programa : progs) {
			if (programa.getDuracion() < durMaxima) {
				programasord.add(programa);
			}
		}

		return programasord;
	}
}
