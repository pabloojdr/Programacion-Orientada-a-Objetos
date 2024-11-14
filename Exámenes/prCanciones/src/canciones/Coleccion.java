package canciones;

import java.util.ArrayList;

public class Coleccion {
	ArrayList<Cancion> canciones;

	public Coleccion() {
		canciones = new ArrayList<Cancion>();
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	protected boolean iguales(ArrayList<Cancion> a, ArrayList<Cancion> b) {
		boolean igual = false;

		if (a.size() == b.size()) {
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).getTitulo().equalsIgnoreCase(b.get(i).getTitulo())) {
					igual = true;
				}
			}
		}
		return igual;
	}

	private int buscarCancion(String t, ArrayList<String> inter) {
		int pos = -1;
		for (int i = 0; i < canciones.size(); i++) {
			if (canciones.get(i).getTitulo().equalsIgnoreCase(t) && canciones.get(i).getInterpretes().equals(inter)) {
				pos = i;
			}
		}
		return pos;
	}

	protected void anyadirCancion(Cancion c) {
		int i = buscarCancion(c.getTitulo(), c.getInterpretes());

		if (i < 0) {
			canciones.add(c);
		} else {
			canciones.set(i, c);
		}
	}

	public void anyadirCancion(String t, ArrayList<String> i, int d, Estilo e){
		anyadirCancion(new Cancion(t, i, d, e));
	}

	public void anyadirCancion(String t, ArrayList<String> i, int d) {
		anyadirCancion(new Cancion(t, i, d));
	}
	
	public void borrarCancion(String t, ArrayList<String> inter) {
		int i = buscarCancion(t, inter);
		
		if(i >= 0) {
			canciones.remove(i);
		}
	}
	
	@Override
	public String toString() {
		return canciones.toString();
	}
	
}
