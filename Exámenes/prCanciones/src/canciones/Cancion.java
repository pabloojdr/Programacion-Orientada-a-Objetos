package canciones;

import canciones.Estilo;
import java.util.ArrayList;

public class Cancion {
	private String titulo;
	private ArrayList<String> interpretes;
	private int duracion;
	private Estilo estilo;

	public Cancion(String t, ArrayList<String> i, int d, Estilo e) {
		if (d < 0) {
			throw new RuntimeException("La duración de la canción no puede ser negativa");
		}
		this.titulo = t;
		this.interpretes = i;
		this.duracion = d;
		this.estilo = e;
	}
	
	public Cancion(String t, ArrayList<String> i, int d) {
		if (d < 0) {
			throw new RuntimeException("La duración de la canción no puede ser negativa");
		}
		this.titulo = t;
		this.interpretes = i;
		this.duracion = d;
		this.estilo = Estilo.OTRO;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public ArrayList<String> getInterpretes(){
		return interpretes;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public Estilo getEstilo() {
		return estilo;
	}
	
	@Override
	public String toString() {
		return getTitulo() + "; " + interpretes.toString() + "; " + getDuracion() + "; " + getEstilo();
	}
}
