//Campoy Fern�ndez, Pablo Juli�n
//Doble grado en ingenier�a inform�tica y matem�ticas (Grupo A)

package parrillatv;

import java.util.*;

public class OrdenAlternativoTV implements Comparator<ProgramaTV> {

	public int compare(ProgramaTV t1, ProgramaTV t2) {
		int resultado = t1.getNombre().compareToIgnoreCase(t2.getNombre());

		if (resultado == 0) {
			resultado = t1.getDuracion() - t2.getDuracion();

			if (resultado == 0) {
				resultado = t1.getHoraInicio().compareTo(t2.getHoraInicio());
			}
		}

		return resultado;
	}
}
