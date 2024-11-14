package notas;

import java.util.ArrayList;

public class MediaAritmetica implements CalculoMedia {
	
	public MediaAritmetica() {
		
	}
	
	public double calcula(ArrayList<Alumno> alumnos) throws AlumnoException {
		double sum = 0;
		double cont = 0;
		
		for(int i = 0; i < alumnos.size(); i++) {
			sum += alumnos.get(i).getCalificacion();
			cont++;
		}
		
		if(alumnos.size() == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		
		return sum / cont;
	}

}
