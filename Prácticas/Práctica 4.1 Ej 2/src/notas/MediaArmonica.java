package notas;

import java.util.ArrayList;

public class MediaArmonica implements CalculoMedia{

	public MediaArmonica() {

	}

	public double calcula(ArrayList<Alumno> alumnos) throws AlumnoException {
		double sum = 0;
		double cont = 0;

		for (int i = 0; i < alumnos.size(); i++) {
			sum += 1 / alumnos.get(i).getCalificacion();
			cont++;
		}

		if (alumnos.size() == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		return cont / sum;
	}
}
