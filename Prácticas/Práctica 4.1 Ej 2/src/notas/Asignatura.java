package notas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Asignatura {

	private String nombre;
	private ArrayList<String> errores = new ArrayList<String>();
	private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

	public Asignatura(String nombre, String[] alumn) {

		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.errores = new ArrayList<String>();

		for (String entrada : alumn) {
			try {
				String[] campos = entrada.split(";");

				String dni = campos[0];
				String nombres = campos[1];
				Double nota = Double.parseDouble(campos[2]);

				alumnos.add(new Alumno(dni, nombres, nota));

			} catch (NumberFormatException e) {
				errores.add("ERROR. Calificación no numérica: " + entrada);

			} catch (ArrayIndexOutOfBoundsException ee) {
				errores.add("ERROR. Faltan datos: " + entrada);

			} catch (AlumnoException eee) {
				errores.add("ERROR. " + eee.getMessage() + ": " + entrada);

			} catch (Exception e) {
				errores.add("ERROR. Genérico: " + entrada);
			}
		}

	}

	/*
	 * private void procesarEntradasSplit(String[] entradas) { for (String entrada :
	 * entradas) { try { String[] campos = entrada.split(";");
	 * 
	 * String dni = campos[0]; String nombre = campos[1]; Double nota =
	 * Double.parseDouble(campos[2]);
	 * 
	 * alumnos.add(new Alumno(dni, nombre, nota));
	 * 
	 * } catch (NumberFormatException e) { errores.add("ERROR. Nota no numérica: " +
	 * entrada);
	 * 
	 * } catch (ArrayIndexOutOfBoundsException e) {
	 * errores.add("Error. Faltan datos: " + entrada);
	 * 
	 * } catch (AlumnoException e) { errores.add("ERROR. " e.getMessage() + ": " +
	 * entrada);
	 * 
	 * } catch (Exception e) { errores.add("ERROR. Genérico: " + entrada); } } }
	 */

	// Forma alternativa: con Scanner

	/*
	 * private void procesarEntradaScanner(String[] entradas) { for(String entrada :
	 * entradas) { try (Scanner) } }
	 * 
	 */

	private int buscarAlumno(String nombre) {
		int i = 0;
		while ((i < alumnos.size()) && !nombre.equals(alumnos.get(i).getNombre())) {
			i++;
		}
		return (i < alumnos.size()) ? i : -1;
	}

	public double getCalificacion(Alumno al) throws AlumnoException {
		double cal = 0;
		if (buscarAlumno(al.getNombre()) >= 0) {
			cal = al.getCalificacion();
		} else if (buscarAlumno(al.getNombre()) == -1) {
			throw new AlumnoException("El alumno " + al.getNombre() + " " + al.getDni() + "no se encuentra");
		}

		return cal;
	}

	public double getMedia() throws AlumnoException {
		double sum = 0;
		double cont = 0;

		for (int i = 0; i < alumnos.size(); i++) {
			sum += alumnos.get(i).getCalificacion();
			cont++;
		}

		if (alumnos.size() == 0) {
			throw new AlumnoException("No hay alumnos");
		}

		return sum / cont;
	}

	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public ArrayList<String> getErrores() {
		return errores;
	}

	public double getMedia(CalculoMedia calc) throws AlumnoException {
		return calc.calcula(alumnos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nombre);
		sb.append(": { ");
		sb.append(this.alumnos.toString());
		sb.append(", ");
		sb.append(this.errores.toString());
		sb.append(" }");

		return sb.toString();

	}

}
