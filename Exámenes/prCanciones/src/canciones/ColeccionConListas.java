package canciones;

import java.util.ArrayList;

public class ColeccionConListas extends Coleccion {

	protected boolean incluido(ArrayList<String> inters, String inter) {
		int i = 0;
		boolean incluido = false;
		while (i < inters.size()) {
			if (inters.get(i).equalsIgnoreCase(inter)) {
				incluido = true;
			}
			i++;
		}
		return incluido;
	}

	public ArrayList<Cancion> crearLista(String inter) {
		boolean incl = false;
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		for (int i = 0; i < super.canciones.size(); i++) {
			incl = incluido(super.canciones.get(i).getInterpretes(), inter);

			if (incl == true) {
				lista.add(super.canciones.get(i));
			}
		}
		return lista;
	}

	public ArrayList<Cancion> crearLista(Estilo e) {
		ArrayList<Cancion> lista = new ArrayList<Cancion>();

		for (int i = 0; i < super.canciones.size(); i++) {
			if (e == super.canciones.get(i).getEstilo()) {
				lista.add(super.canciones.get(i));
			}
		}
		return lista;
	}
}
