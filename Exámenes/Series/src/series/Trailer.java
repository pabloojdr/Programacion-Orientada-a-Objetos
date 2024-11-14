package series;

public class Trailer {
	private String titulo;
	private int duracion;
	
	public Trailer(String t, int d) {
		if(d > 5) {
			throw new SerieException("La duración del trailer no puede ser superior a 5 minutos");
		}
		
		this.titulo = t;
		this.duracion = d;
	}
	
	
}
