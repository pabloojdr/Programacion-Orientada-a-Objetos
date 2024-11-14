package rutas;

import java.util.*;

public class OrdenETSIInfUMA implements Comparator<Lugar> {
	private final static Lugar ETSIInfUMA = new Lugar("E.T.S.I. Informática", 36.715, -4.477);

	public int compare(Lugar l1, Lugar l2) {
		double d1 = l1.distancia(ETSIInfUMA);
		double d2 = l2.distancia(ETSIInfUMA);

		return Double.compare(d1, d2);
	}
}
