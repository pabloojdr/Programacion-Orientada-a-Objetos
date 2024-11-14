package rutas;

import java.io.*;
import java.util.*;

public class Ruta {
	private String nombreRuta;
	protected List<Lugar> lugares;

	public Ruta(String n) {
		nombreRuta = n;
		lugares = new ArrayList<>();
	}

	public void agregar(Lugar l) {
		if (l == null) {
			throw new RutasException("El lugar a agregar no puede ser null");
		}
		lugares.add(l);
	}

	public void agregarLugares(String f) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(f))) {
			agregarLugares(sc);
		}

	}

	public void agregarLugares(Scanner sc) {
		String linea = sc.nextLine();
		try (Scanner scLinea = new Scanner(linea)) {
			sc.useDelimiter("[@:]+");
			sc.useLocale(Locale.ENGLISH);
			String nombre = scLinea.nextLine();
			double latitud = scLinea.nextDouble();
			double longitud = scLinea.nextDouble();

			lugares.add(new Lugar(nombre, latitud, longitud));
		} catch (InputMismatchException ime) {
			throw new RutasException("Se espera un dato numérico en la línea: " + linea);
		} catch (NoSuchElementException nsee) {
			throw new RutasException("Se esperaban más datos en la línea: " + linea);
		} catch (RutasException re) {
			throw new RutasException("Los datos geoposicionales no están en el rango en la línea: " + linea);
		}
	}

	public String getNombreRuta() {
		return nombreRuta;
	}

	public Lugar origen() {
		if (lugares.isEmpty()) {
			throw new RutasException("La ruta está vacía");
		}

		return lugares.get(0);
	}

	public Lugar destino() {
		if (lugares.isEmpty()) {
			throw new RutasException("La ruta está vacía");
		}

		return lugares.get(lugares.size() - 1);
	}

	public boolean estaEnRuta(Lugar l) {
		return lugares.contains(l);
	}

	public double distanciaRuta() {
		double sum = 0.0;
		for (int i = 0; i < lugares.size() - 1; ++i) {
			sum += lugares.get(i).distancia(lugares.get(i + 1));
		}
		return sum;
	}

	public void guardarRuta(String fichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fichero);
		guardarRuta(pw);
	}

	public void guardarRuta(PrintWriter pw) {
		pw.println(nombreRuta.toUpperCase() + ": ");
		for (Lugar l : lugares) {
			pw.println("\t" + l);
		}
	}

}
