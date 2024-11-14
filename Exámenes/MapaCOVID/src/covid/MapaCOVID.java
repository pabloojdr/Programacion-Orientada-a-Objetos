package covid;

import java.io.*;
import java.util.*;

public class MapaCOVID {
	private String nombre;
	private SortedMap<String, SortedSet<DistritoSanitario>> mapa;

	public MapaCOVID(String n, String fichero) throws FileNotFoundException {
		nombre = n;
		mapa = new TreeMap<>();
		leerDatos(fichero);
	}

	public void leerDatos(String fichero) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fichero))) {
			leerDatos(sc);
		}
	}

	public void leerDatos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			leerDatosLinea(linea);
		}
	}

	private void leerDatosLinea(String l) {
		try (Scanner scL = new Scanner(l)) {
			scL.useDelimiter("[():]+");
			DistritoSanitario ds = new DistritoSanitario(scL.next(), scL.nextInt(), scL.nextInt());
			String provincia = scL.next();
			agregarDistrito(provincia, ds);
		} catch (NoSuchElementException | COVIDException nsee) {
			// se ignora
		}
	}

	public void agregarDistrito(String p, DistritoSanitario ds) {
		SortedSet<DistritoSanitario> distritos = mapa.get(p);
		if (distritos == null) {
			distritos = new TreeSet<>();
			mapa.put(p, distritos);
		}

		distritos.add(ds);
	}

	public String getNombre() {
		return nombre;
	}

	public Set<String> getProvincias() {
		return mapa.keySet();
	}

	public Set<DistritoSanitario> getDistritos() {
		SortedSet<DistritoSanitario> distritos = new TreeSet<>();
		for (SortedSet<DistritoSanitario> distritosProv : mapa.values()) {
			distritos.addAll(distritosProv);
		}
		return distritos;
	}

	public int incidenciaProvincia(String p) {
		SortedSet<DistritoSanitario> distritos = mapa.get(p);
		int pb = 0;
		int cs = 0;
		int res = 0;
		if (distritos != null) {
			for (DistritoSanitario ds : distritos) {
				pb += ds.getPoblacion();
				cs += ds.getCasosCOVID14dias();
			}
			res = (100000 * pb / cs);
		}

		return res;
	}

	public void mostrarMapa(String nomFich) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(nomFich))) {
			mostrarMapa(pw);
		}
	}

	public void mostrarMapa(PrintWriter pw) {
		pw.println(nombre.toUpperCase() + ":");

		for (Map.Entry<String, SortedSet<DistritoSanitario>> entrada : mapa.entrySet()) {
			pw.println(entrada.getKey());
			for (DistritoSanitario ds : entrada.getValue()) {
				pw.println("\t" + ds);
			}
		}
	}
	
	

}
