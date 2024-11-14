package prConcesionario;

import java.util.ArrayList;

public class Concesionario {
	public static int TAM = 10;
	private ArrayList<Coche> concesionario;

	public Concesionario() {
		concesionario = new ArrayList<Coche>(TAM);
	}

	public Concesionario(int n_elementos) {
		concesionario = new ArrayList<Coche>(n_elementos);
	}

	public int buscarCoche(String m) {
		int i = 0;
		while (i < concesionario.size() && !(concesionario.get(i).getModelo().equalsIgnoreCase(m))) {
			i++;
		}

		return (i < concesionario.size()) ? i : -1;

	}

	protected void anyadirCoche(Coche c1) {
		int i = buscarCoche(c1.getModelo());

		if (i < 0) {
			concesionario.add(c1);
		}

		else if (i > 0) {
			concesionario.set(i, c1);
		}
	}

	public void addCoche(String m, double p) {
		anyadirCoche(new Coche(m, p));
	}

	public void eliminarCoche(String m) {
		int i = 0;

		while (i < concesionario.size()) {
			if (concesionario.get(i).getModelo() == m) {
				concesionario.remove(i);
			}

			else {
				throw new RuntimeException("El coche introducido no ha sido encontrado");
			}
		}
	}

	public Coche cocheMasBarato() {
		if (concesionario.size() == 0) {
			throw new RuntimeException("No hay coches en el concesionario");
		}

		else {
			double m = concesionario.get(0).calcPrecioFinal();
			String nom = null;
			for (int i = 0; i < concesionario.size(); ++i) {
				if (m > concesionario.get(i).calcPrecioFinal()) {
					m = concesionario.get(i).calcPrecioFinal();
					nom = concesionario.get(i).getModelo();
				}
			}

			return concesionario.get(buscarCoche(nom));
		}
	}

	public ArrayList<Coche> seleccionar(SelectorCoche c) {
		ArrayList<Coche> seleccionados = new ArrayList<Coche>();
		for (Coche co : concesionario) {
			if (c.esSeleccionable(co) == true) {
				seleccionados.add(co);
			}
		}

		return seleccionados;
	}

	@Override
	public String toString() {
		return concesionario.toString();
	}

}
