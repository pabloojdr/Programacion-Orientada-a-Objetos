package notas;

import java.util.ArrayList;

public interface CalculoMedia {
	double calcula(ArrayList<Alumno> alumnos) throws AlumnoException;
}
