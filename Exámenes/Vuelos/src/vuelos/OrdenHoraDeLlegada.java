package vuelos;

import java.util.*;

public class OrdenHoraDeLlegada implements Comparator<Vuelo> {

	@Override
	public int compare(Vuelo v1, Vuelo v2) {
		int result = v1.getHoraLlegada().compareTo(v2.getHoraLlegada());

		if (result == 0) {
			result = v1.compareTo(v2);
		}

		return result;
	}
}
