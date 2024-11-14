package alturas;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Mundo {
	private List<Pais> paises;

	public Mundo() {
		paises = new ArrayList<Pais>();
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void cargar(String file) throws IOException {
		paises.clear();

		try (Scanner sc = new Scanner(new File(file))) {
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				try {
					String datos[] = linea.split(",");
					paises.add(new Pais(datos[0], datos[1], Double.parseDouble(datos[2])));
				} catch (Exception e) {

				}
			}
		}
	}

	public SortedMap<String, Integer> numeroDePaisesPorContinente() {
		SortedMap<String, Integer> pc = new TreeMap<String, Integer>();

		for (Pais pais : paises) {
			int n = pc.getOrDefault(pais.getContinente(), 0);
			n++;
			pc.put(pais.getContinente(), n);

		}

		return pc;
	}

	// Paises por continente. Continentes y paises ordenados por el orden natural
	public SortedMap<String, Set<Pais>> paisesPorContinente() {
		SortedMap<String, Set<Pais>> result = new TreeMap<String, Set<Pais>>();

		for (Pais pais : paises) {
			String continente = pais.getContinente();
			Set<Pais> set = result.getOrDefault(continente, new TreeSet<Pais>());
			set.add(pais);
			result.put(continente, set);
		}

		return result;
	}

	// Métodos genéricos para presentar resultados en PrintWriter y consola
	public static <K, V> void presentaEnPW(PrintWriter pw, Map<K, V> map) {

		for (K k : map.keySet()) {
			pw.println(k + "\t" + map.get(k));
		}
	}

	// Métodos genéricos para presentar resultados en PrintWriter y consola
	public static <K, V> void presentaEnConsola(Map<K, V> map) {

		PrintWriter pw = new PrintWriter(System.out, true);
		presentaEnPW(pw, map);
	}

	public SortedMap<Character, Set<Pais>> paisesPorInicial() {
		SortedMap<Character, Set<Pais>> result = new TreeMap<Character, Set<Pais>>();

		for (Pais pais : paises) {
			char inicial = pais.getNombre().charAt(0);
			Set<Pais> set = result.getOrDefault(inicial, new TreeSet<Pais>());
			set.add(pais);
			result.put(inicial, set);
		}

		return result;
	}

	public SortedMap<Double, List<Pais>> paisesPorAltura() {
		SortedMap<Double, List<Pais>> result = new TreeMap<Double, List<Pais>>();

		for (Pais pais : paises) {
			double alt = (int) (pais.getAltura() * 10) / 10.0; // para truncar
			List<Pais> list = result.getOrDefault(alt, new ArrayList<Pais>());
			list.add(pais);
			result.put(alt, list);
		}

		return result;
	}

	public SortedMap<String, Double> mediaPorContinente() {

	}

	public SortedMap<Double, List<Pais>> continentesConMasPaises() {

	}

	public Set<Pais> paisesOrdenadosPorAltura() {
		Set<Pais> set = new TreeSet<Pais>(new CompAltura());

		set.addAll(paises);

		return set;
	}
	
	public Map<String, Set<Pais>> paisesPorContinenteAltura(){
		SortedMap<String, Set<Pais>> result = new TreeMap<String, Set<Pais>>();

		for (Pais pais : paises) {
			String continente = pais.getContinente();
			Set<Pais> set = result.getOrDefault(continente, new TreeSet<Pais>(new CompAltura()));
			set.add(pais);
			result.put(continente, set);
		}

		return result;
	}
	
	public Map<String, Set<Pais>> paisesPorContinenteAlturaDec(){
		SortedMap<String, Set<Pais>> result = new TreeMap<String, Set<Pais>>();

		for (Pais pais : paises) {
			String continente = pais.getContinente();
			Set<Pais> set = result.getOrDefault(continente, new TreeSet<Pais>(new CompAltura().reversed()));
			set.add(pais);
			result.put(continente, set);
		}

		return result;
	}
}
