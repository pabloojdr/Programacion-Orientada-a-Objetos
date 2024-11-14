//Campoy Fernández, Pablo Julián
//Doble grado en ingeniería informática y matemáticas (Grupo A)

package parrillatv;

import java.util.*;

public class ProgramaTV implements Comparable<ProgramaTV> {
	private String nombre;
	private int duracion;
	private Hora horaInicio;

	public ProgramaTV(String n, Hora hi, int d) {
		if (d < 0) {
			throw new ProgramacionTVException("La duración no puede ser negativa");
		}

		nombre = n;
		horaInicio = hi;
		duracion = d;
	}

	public String getNombre() {
		return nombre;
	}

	public Hora getHoraInicio() {
		return horaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public Hora getHoraFin() {
		horaInicio.incrementar(duracion);
		return horaInicio;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof ProgramaTV && ((ProgramaTV) o).nombre.equalsIgnoreCase(nombre)
				&& ((ProgramaTV) o).duracion == duracion && ((ProgramaTV) o).horaInicio.equals(horaInicio));
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre.toUpperCase(), duracion, horaInicio);
	}

	@Override
	public int compareTo(ProgramaTV t) {
		int resultado = horaInicio.compareTo(t.horaInicio);

		if (resultado == 0) {
			resultado = duracion - t.duracion;

			if (resultado == 0) {
				resultado = nombre.compareTo(t.nombre);
			}
		}

		return resultado;
	}

	@Override
	public String toString() {
		return nombre.toUpperCase() + "@" + horaInicio + "-" + duracion;
	}

}
