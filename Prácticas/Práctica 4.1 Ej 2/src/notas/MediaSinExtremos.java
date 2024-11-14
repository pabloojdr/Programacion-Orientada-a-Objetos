package notas;

import java.util.ArrayList;

public class MediaSinExtremos implements CalculoMedia {
	private double min;
	private double max;

	public MediaSinExtremos(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double calcula(ArrayList<Alumno> alumnos) {
		double sum = 0;
		double cont = 0;

		for (int i = 0; i < alumnos.size(); i++) {
			if (min <= alumnos.get(i).getCalificacion() && alumnos.get(i).getCalificacion() <= max) {
				sum += alumnos.get(i).getCalificacion();
				cont++;
			}
		}

		return sum / cont;
	}
}
