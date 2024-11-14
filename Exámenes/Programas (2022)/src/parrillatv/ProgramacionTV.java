//Campoy Fernández, Pablo Julián
//Doble grado en ingeniería informática y matemáticas (Grupo A)

package parrillatv;

import java.io.*;
import java.util.*;

public class ProgramacionTV {
	protected Map<String, SortedSet<ProgramaTV>> cadenas;

	public ProgramacionTV() {
		cadenas = new HashMap<String, SortedSet<ProgramaTV>>();
	}

	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> programas = cadenas.getOrDefault(cadenaTV, new TreeSet<>());

		programas.add(prog);
		cadenas.put(cadenaTV, programas);
	}

	public void leerProgramas(String fichero) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fichero))) {
			leerProgramas(sc);
		}
	}

	private void leerProgramas(Scanner sc) {
		while (sc.hasNext()) {
			String linea = sc.nextLine();
			leerProgramasLinea(linea);
		}
	}

	private void leerProgramasLinea(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[>@:-]+");
			String nombca = sc.next();
			String nombpro = sc.next();
			int hora = sc.nextInt();
			int min = sc.nextInt();
			int duracion = sc.nextInt();

			Hora h = new Hora(hora, min);
			ProgramaTV p = new ProgramaTV(nombpro, h, duracion);

			agregar(nombca, p);
		} catch (InputMismatchException ime) {
			// se ignora
		} catch (NoSuchElementException nse) {
			// se ignora
		} catch (ProgramacionTVException pte) {
			// se ignora
		}
	}

	public void mostrarProgramas(String fichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(fichero)) {
			mostrarProgramas(pw);
		}
	}

	public void mostrarProgramas(PrintWriter pw) {
		Set<String> nombcadenas = cadenas.keySet();

		for (String cadena : nombcadenas) {
			pw.println(cadena);

			SortedSet<ProgramaTV> programas = cadenas.get(cadena);
			for (ProgramaTV programa : programas) {
				pw.println("\t" + programa);
			}
		}
	}

	public boolean esConsistente(String cadenaTV) {
		if (!cadenas.containsKey(cadenaTV)) {
			throw new ProgramacionTVException("La cadena de TV indicada no aparece en la parrilla");
		}

		int resultado = 0;
		boolean resultadoverd = true;
		SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
		List<ProgramaTV> programa = new ArrayList<>(programas);

		for (int i = 0; i < programa.size() - 1; i++) {
			resultado = programa.get(i).getHoraFin().compareTo(programa.get(i + 1).getHoraInicio());

			if (resultado > 0) {
				resultadoverd = false;
			}
		}

		return resultadoverd;
	}

	public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion) {
		Set<ProgramaTV> programas = new TreeSet<>();
		Set<String> cads = cadenas.keySet();

		for (String cadena : cads) {
			Set<ProgramaTV> progs = cadenas.get(cadena);
			programas.addAll(progs);
		}

		return seleccion.sugerencias(programas);
	}

}
