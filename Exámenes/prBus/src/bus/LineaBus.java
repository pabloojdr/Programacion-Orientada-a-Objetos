package bus;

import java.util.ArrayList;

public class LineaBus {
	private String nombreLinea;
	ArrayList<Parada> linea;

	public LineaBus(String n) {
		this.nombreLinea = n;
		linea = new ArrayList<Parada>();
	}

	public void agregar(Parada parada) {
		linea.add(parada);
	}

	public void cambiar(String np, Parada nuevaParada) {
		int i = numeroParada(np);
		if (i >= 0) {
			linea.set(i, nuevaParada);
		} else if (i < 0) {
			throw new RuntimeException("La parada no está en la linea");
		}
	}

	public boolean pasaPor(String n) {
		boolean pasa = false;
		int i = numeroParada(n);
		if (i >= 0) {
			pasa = true;
		}
		return pasa;
	}

	private int numeroParada(String n) {
		int pos = -1;

		for (int i = 0; i < linea.size(); i++) {
			if (n.equalsIgnoreCase(linea.get(i).getNombre())) {
				pos = i;
			}
		}
		return pos;
	}

	public String getNombreLinea() {
		return nombreLinea;
	}

	public Parada inicio() {
		if (linea == null) {
			throw new RuntimeException("La linea no contiene ninguna parada");
		}
		return linea.get(0);
	}

	public Parada fin() {
		if (linea == null) {
			throw new RuntimeException("La linea no contiene ninguna parada");
		}
		return linea.get(linea.size() - 1);
	}

	public double distanciaLinea() {
		double sum = 0;
		if (linea.isEmpty() == false) {
			for (int i = 0; i < linea.size() - 1; i++) {
				sum += linea.get(i).distancia(linea.get(i + 1));
			}
		}else {
			sum = 0;
		}
		return sum;
	}

	public String toString() {
		return getNombreLinea().toUpperCase() + linea.toString();
	}
}
