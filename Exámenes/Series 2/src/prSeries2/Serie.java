package prSeries2;

import java.util.ArrayList;
import java.util.Scanner;

public class Serie {
	private String titulo;
	private ArrayList<Episodio> episodios;
	
	public Serie(String t, String[] datos) throws SerieException {
		this.episodios = new ArrayList<Episodio>();
		
		for(String d : datos) {
			try(Scanner sc = new Scanner(d)){
				sc.useDelimiter("[:]");
				int cap = sc.nextInt();
				String ti = sc.next();
				int du = sc.nextInt();
				
				episodios.add(new Episodio(cap, ti, du));
			}catch(Exception e) {
				throw new SerieException("ERROR AL INTRODUCIR LOS DATOS");
			}
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int duracionTotal() {
		int duracion = 0;
		for(Episodio e : episodios) {
			duracion += e.getDuracion();
		}
		
		return duracion;
	}
	
	private int buscarEpisiodio(Episodio e) {
		
		return pos;
	}
	
	public Episodio obtenerEpisodio(int cap) {
		for(Episodio ep : episodios) {
			if(ep.getCapitulo() == cap) {
				return ep;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return titulo + " -> " + episodios.toString();
	}
}
