/*Campoy Fernández Pablo Julián
 * Doble Grado en ingeniería informatica y matemáticas
 * Grupo A
 */

package bus;

public class Parada {
	private static final double RADIO_TIERRA = 6378.137;
	private String nombre;
	private double latitud;
	private double longitud;

	public Parada(String n, double la, double lon) {
		if (la > 90 || la < -90 || lon < -180 || lon > 180) {
			throw new RuntimeException(
					"Introduce datos correctos para la latitud (-90 < latidud < 90) y/o longitud (-180 < longitud < 180)");
		}
		this.nombre = n;
		this.latitud = la;
		this.longitud = lon;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nuevo_n) {
		this.nombre = nuevo_n;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public double getLatitud() {
		return latitud;
	}
	
	public static double distanciaHaversine(Parada p1, Parada p2) {
		// Conversión a radianes de latitudes y longitudes de p1 y p2
		double ltRad1 = Math.toRadians(p1.latitud);
		double lgRad1 = Math.toRadians(p1.longitud);
		double ltRad2 = Math.toRadians(p2.latitud);
		double lgRad2 = Math.toRadians(p2.longitud);
		// Se utiliza la fórmula de Havershine para aproximar la distancia
		double distancia = RADIO_TIERRA * Math.acos(
		Math.cos(ltRad1) * Math.cos(ltRad2) * Math.cos(lgRad2-lgRad1)
		+ Math.sin(ltRad1) * Math.sin(ltRad2)
		);
		return distancia;
		}
	
	public double distancia(Parada parada) {
		return distanciaHaversine(this, parada);
	}
	
	public String toString() {
		return getNombre().toUpperCase() + "(" + getLatitud() + ", " + getLongitud() + ")";
	}
}
