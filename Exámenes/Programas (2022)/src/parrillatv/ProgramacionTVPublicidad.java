//Campoy Fernández, Pablo Julián
//Doble grado en ingeniería informática y matemáticas (Grupo A)

package parrillatv;

import java.util.*;

public class ProgramacionTVPublicidad extends ProgramacionTV {

	public ProgramacionTVPublicidad() {
		super();
	}

	public void agregar(String cadena, ProgramaTV p) {
		SortedSet<ProgramaTV> programas = cadenas.get(cadena);
		ProgramaTV publicidad = new ProgramaTV("Publicidad", p.getHoraFin(), 5);

		if (programas.isEmpty()) {
			programas = new TreeSet<>();
		}

		programas.add(p);
		programas.add(publicidad);
		cadenas.put(cadena, programas);
	}
}
