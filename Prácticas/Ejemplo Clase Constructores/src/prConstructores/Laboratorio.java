package prConstructores;

public class Laboratorio extends Aula {
	// Si no pongo la nada, es como si pusiera public Laboratorio(){ ...

	public Laboratorio(String n) {
		super();	// Esto invoca la clase Aula, si en Aula no existe un constructor sin
					// argumentos, entocen esto te da error
		
		this(); 	// hace referencia a la clase Laboratorio.
	}
	
	public Laboratorio() {
		super("3.0.1B");
	}
}
