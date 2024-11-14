package notas;

import java.util.Objects;

public class Alumno {

	private String dni;
	private String nombre;
	private double nota;

	public Alumno(String dni, String nombre, double nota) throws AlumnoException {
		if (nota < 0) {
			throw new AlumnoException("Calificación negativa");
		}

		this.dni = dni;
		this.nombre = nombre;
		this.nota = nota;
	}

	public Alumno(String dni, String nombre) throws AlumnoException {
		this(dni, nombre, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return nota;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Alumno) {
			Alumno a = (Alumno) o;
			if (this.nombre.equals(a.nombre) && this.dni.equalsIgnoreCase(a.dni)) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Alumno;
		Alumno a = res ? (Alumno) obj : null;
		return res && nombre.equals(a.nombre) && dni.equalsIgnoreCase(a.dni);
	}
	*/
	
	@Override
	public int hashCode() { // necesario redefinirlo siempre que lo hagamos con equals
		return nombre.hashCode() + dni.toLowerCase().hashCode(); //Tambien funciona con el método .toUpperCase()
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(" ");
		sb.append(dni);

		return sb.toString();
	}

	/*
	 * public String toString() { return nombre + " " + dni; }
	 */
}
