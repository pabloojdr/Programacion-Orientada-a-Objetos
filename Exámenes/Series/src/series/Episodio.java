package series;

import java.util.Objects;

public class Episodio {
	private String titulo;
	private int duracion;
	private int capitulo;
	
	public Episodio(String t, int d, int c) {
		if(d < 0 || c  < 0) {
			throw new SerieException("El numero de capitulo y la duración deben ser positivos");
		}
		
		this.titulo = t;
		this.duracion = d;
		this.capitulo = c;
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
		return ((o instanceof Episodio) && ((Episodio) o).titulo.equalsIgnoreCase(titulo) && ((Episodio) o).duracion == duracion);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo, duracion);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Episodio ");
		sb.append(capitulo);
		sb.append(": ");
		sb.append(titulo);
		sb.append(" (");
		sb.append(duracion);
		sb.append(" min)");
		
		return sb.toString();
	}
}
