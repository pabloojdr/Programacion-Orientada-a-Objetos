package libreria;

import java.util.ArrayList;

public class Libreria {
	private ArrayList<Libro> libs;

	public Libreria() {
		 libs = new ArrayList<Libro>();
	}

	private int buscarLibro(String autor, String titulo) {
		int i = 0;
		while ((i < libs.size()) && !(libs.get(i).getAutor().equalsIgnoreCase(autor)
				&& libs.get(i).getTitulo().equalsIgnoreCase(titulo)))
			++i;

		return (i < libs.size()) ? i : -1; // if(i == libs.size()( return -1;
											// else { return i; }
	}

	protected void anyadirLibro(Libro l) {
		int i = buscarLibro(l.getAutor(), l.getTitulo());

		if (i < 0)
			libs.add(l);

		else {
			libs.set(i, l);
		}
	}

	public void addLibro(String autor, String titulo, double precioBase) {
		anyadirLibro(new Libro(autor, titulo, precioBase));
	}
	
	@Override
	public String toString() {
		return libs.toString();
	}
}
