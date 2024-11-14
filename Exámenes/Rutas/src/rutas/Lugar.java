package rutas;

import java.util.Objects;

public class Lugar {
	private String nombre;
	private double latitud;
	private double longitud;
	private final static double RADIO_TIERRA = 6378.137;

	public Lugar(String n, double lat, double lon) {
		if (lat < -90 || 90 < lat || lon < -180 || 180 < lon) {
			throw new RutasException(
					"El valor de la latitud o la longitud no es correcto (-90 < latitud < 90 y -180 < longitud < 180");
		}

		nombre = n;
		latitud = lat;
		longitud = lon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Lugar) && ((Lugar) o).nombre.equalsIgnoreCase(nombre) && ((Lugar) o).latitud == latitud
				&& ((Lugar) o).longitud == longitud);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), latitud, longitud);
	}
	
	public int distancia(Lugar l) {
		double ltRad1 = Math.toRadians(l.latitud);
		double lgRad1 = Math.toRadians(l.longitud);
		double ltRad2 = Math.toRadians(latitud);
		double lgRad2 = Math.toRadians(longitud);
		double distancia = RADIO_TIERRA * Math.acos(
								Math.cos(ltRad1)*Math.cos(ltRad2)*Math.cos(lgRad2-lgRad1) + 
								Math.sin(ltRad1)*Math.sin(ltRad2)
							  );
		return (int) Math.ceil(distancia*1000) / 1000;
	}
	
	@Override
	public String toString() {
		return nombre.toUpperCase() + ": " + latitud + "," + longitud;
	}
}
