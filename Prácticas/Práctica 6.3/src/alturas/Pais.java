package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
	private String nombre;
	private String continente;
	private double altura;

	public Pais(String n, String c, double a) {
		this.nombre = n;
		this.continente = c;
		this.altura = a;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContinente() {
		return continente;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Pais) && ((Pais) o).nombre.equals(nombre));
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public int compareTo(Pais p) {
		return nombre.compareTo(p.nombre);
	}

	@Override
	public String toString() {
		return "Pais(" + nombre + ", " + continente + ", " + altura + ")";
	}
}
