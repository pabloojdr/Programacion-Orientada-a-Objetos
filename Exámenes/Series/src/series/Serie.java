package series;

import java.util.ArrayList;

public class Serie {
	private String titulo;
	private ArrayList<Episodio> episodios = new ArrayList<>();

	public Serie(String t, String[] ep) {
		try {
			this.titulo = t;
			for (String eps : ep) {
				String[] epi = eps.split(":");

				Episodio e = new Episodio(epi[1], Integer.parseInt(epi[2]), Integer.parseInt(epi[0]));

				episodios.add(e);
			}
		} catch (Exception e) {
			throw new SerieException();
		}
	}

	public int duracionTotal() {
		int total = 0;
		for (int i = 0; i < episodios.size(); i++) {
			total += episodios.get(i).getDuracion();
		}

		return total;
	}

	public Episodio obtenerEpisodio(int cap) {
		int pos = -1;
		for (int i = 0; i < episodios.size(); i++) {
			if (episodios.get(i).getCapitulo() == cap) {
				pos = i;
			}
		}

		return pos < 0 ? null : episodios.get(pos);
	}

	public String toString() {
		return this.titulo + ": " + episodios.toString();
	}
}
