package covid;

import java.util.Objects;

public class DistritoSanitario implements Comparable<DistritoSanitario> {
	private String distrito;
	private int poblacion;
	private int casosCOVID14dias;

	public DistritoSanitario(String d, int p, int c) {
		if (p <= 0 || c < 0) {
			throw new COVIDException(
					"La poblacion no puede ser menor o igual que cero / Los casos no pueden ser menores que cero");
		}

		this.distrito = d;
		this.poblacion = p;
		this.casosCOVID14dias = c;
	}

	public String getDistrito() {
		return distrito;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public int getCasosCOVID14dias() {
		return casosCOVID14dias;
	}

	public void setCasosCOVID14dias(int n) {
		if (n < 0) {
			throw new COVIDException("Los casos de COVID no pueden ser negativos");
		}
		this.casosCOVID14dias = n;
	}

	public int incidenciaAcumulada() {
		return (int) (100000.0 * this.casosCOVID14dias / poblacion);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof DistritoSanitario && ((DistritoSanitario) o).distrito.equalsIgnoreCase(distrito));
	}

	@Override
	public int hashCode() {
		return Objects.hash(distrito.toUpperCase());
	}

	@Override
	public int compareTo(DistritoSanitario s) {
		return s.distrito.compareToIgnoreCase(distrito);
	}

	@Override
	public String toString() {
		return "Distrito (" + distrito + "," + this.casosCOVID14dias + ")";
	}

}
