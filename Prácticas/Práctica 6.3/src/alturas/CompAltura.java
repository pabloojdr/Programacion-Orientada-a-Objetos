package alturas;

import java.util.*;

public class CompAltura implements Comparator<Pais> {
	public int compare(Pais p1, Pais p2) {
		int resultado = (int) (p1.getAltura() - p2.getAltura());
		if (resultado == 0) {
			resultado = p1.getNombre().compareTo(p2.getNombre());
		}

		return resultado;
	}

}
