package prSeries2;

import java.util.Objects;

public class Episodio {
	private String titulo;
	private int duracion;
	private int capitulo;

	public Episodio(int c, String t, int d) throws SerieException {
		if (c < 0 || d < 0) {
			throw new SerieException("La duracion o el capitulo no pueden ser negativos");
		}

		this.capitulo = c;
		this.titulo = t;
		this.duracion = d;

	}

	public int getCapitulo() {
		return capitulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Episodio) && ((Episodio) o).getTitulo().equalsIgnoreCase(titulo)
				&& ((Episodio) o).getDuracion() == duracion);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo.toLowerCase(), duracion);
	}
	
	@Override
	public String toString() {
		return "Episodio " + capitulo + ": " + titulo + " (" + duracion + " min)";
	}

}
