import bus.LineaBus;
import bus.LineaBusSentido;
import bus.Parada;



public class PruebasAdicionales {

	public static void main(String[] args) {
		LineaBusSentido linea11 = new LineaBusSentido("Línea 11");
		System.out.println(linea11.distanciaLinea());
	}

	/* SALIDA DEL PROGRAMA DE PRUEBAS
	
	LÍNEA 11[PASEO DEL PARQUE(36.71884,-4.4191), ECHEVERRÍA(36.72181,-4.36351), PEDREGALEJO(36.72248,-4.37685), PASEO DEL PARQUE(36.0,-4.0), PUENTE DE LAS AMÉRICAS(36.71755,-4.43903), LOUIS PASTEUR(36.71654,-4.47508)]
	La primera parada de Línea 11 es PASEO DEL PARQUE(36.71884,-4.4191)
	La última parada de Línea 11 es LOUIS PASTEUR(36.71654,-4.47508)
	 */
	
	
	/* CÓDIGO CON FÓRMULA HAVERSINE PARA CALCULAR LA DISTANCIA 
	 *
	 	public final static double RADIO_TIERRA = 6378.137;
	 	
	 	public static double distanciaHaversine(Parada p1, Parada p2) {
	 		// Conversión a radianes de latitudes y longitudes de p1 y p2
			double ltRad1 = Math.toRadians(p1.latitud);
			double lgRad1 = Math.toRadians(p1.longitud);
			double ltRad2 = Math.toRadians(p2.latitud);
			double lgRad2 = Math.toRadians(p2.longitud);
			// Se utiliza la fórmula de Havershine para aproximar la distancia
			double distancia = RADIO_TIERRA * Math.acos(
				Math.cos(ltRad1) * Math.cos(ltRad2) * Math.cos(lgRad2 - lgRad1) + Math.sin(ltRad1) * Math.sin(ltRad2));
			return distancia;
	}
	 *
	 */
}
