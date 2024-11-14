package vuelos;

import java.io.*;
import java.util.*;

public class Aeropuerto {
	private SortedMap<String, SortedSet<Vuelo>> vuelos;

	public Aeropuerto() {
		vuelos = new TreeMap<>();
	}

	public void agregarVuelo(Vuelo v) {
		String aeropuerto = v.getOrigen().toUpperCase();
		SortedSet<Vuelo> vuelo = vuelos.getOrDefault(aeropuerto, new TreeSet<>());

		vuelos.putIfAbsent(aeropuerto, vuelo);

		vuelo.add(v);
	}

	public void leeVuelos(String fichero) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fichero))) {
			leeVuelos(sc);
		}
	}

	public void leeVuelos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			leeVuelosLinea(linea);
		}
	}

	private void leeVuelosLinea(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[(:,- )]+");
			String codigo = sc.next();
			String aerolinea = sc.next();
			String origen = sc.next();
			String destino = sc.next();
			int horasalida = sc.nextInt();
			int minutosalida = sc.nextInt();
			Hora h = new Hora(horasalida, minutosalida);
			int duracion = sc.nextInt();
			
			agregarVuelo(new Vuelo(aerolinea, codigo, h, duracion, origen, destino));
		} catch (InputMismatchException ime) {

		} catch (NoSuchElementException nsee) {

		} catch (VuelosException ve) {

		}
	}
}
