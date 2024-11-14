package playas;

import java.util.Objects;

public class Playa {
	private String nombre;
	private String localidad;
	private final double latitud;
	private final double longitud;
	private final int aforoMax;
	private int numPersonas;
	protected String estado;

	public Playa(String nombre, String local, double latitud, double longitud, int aforoMax) {

		this.nombre = nombre;
		this.localidad = localidad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.aforoMax = aforoMax;

		if (aforoMax < 0) {
			throw new PlayaException();
		}
	}

	public String getEstado() {
		return estado;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public int getAforoMax() {
		return aforoMax;
	}

	public void setNumPersonas(int n) {
		if (n < 0) {
			throw new PlayaException();
		}

		if (n == 0) {
			estado = "VACIO";
		}

		else if (0 < n && n < 25) {
			estado = "LEVE";
		}

		else if (25 < n && n < 75) {
			estado = "MODERADO";
		}

		else if (75 < n && n < 100) {
			estado = "SATURADO";
		}

		else if (n > 100) {
			estado = "SIN ESPACIO";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Playa) && ((Playa) o).getLatitud() == this.latitud
				&& ((Playa) o).getLongitud() == longitud);

	}

	@Override
	public int hashCode() {
		return Objects.hash(longitud, latitud);
	}

	@Override
	public String toString() {
		return "(" + nombre + ", " + localidad + ", " + latitud + ", " + longitud + ", " + aforoMax + ", " + numPersonas
				+ ", " + " - Nivel de aforo: " + estado + ")";
	}

}
