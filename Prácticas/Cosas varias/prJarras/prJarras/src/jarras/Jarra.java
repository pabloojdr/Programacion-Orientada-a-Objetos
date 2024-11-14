package jarras;

public class Jarra {

	final private int capacidad;
	private int contenido;

	public Jarra(int capacidad) { 		// En el enunciado pone que cuando la creamos usa solo la capacidad.
		if (capacidad <= 0)
			throw new RuntimeException ("La capacidad no puede ser negativa");
		
		contenido = 0; 					// En el enuncidado nos dice que el contenido tiene que ser 0 (vacío) (Podríamos
										// usarlo sin el this., entendería lo mismo).
		this.capacidad = capacidad;		// Una alternativa sería usar (int c) para el argumento del objeto y poner
										// capacidad = c; (Es mejor usar el this. para el atributo del objeto).
										// this.atributo = argumento.

	}
	

	public int capacidad() { // Tanto este como el de abajo, son "getters"
		return capacidad;
	}

	public int contenido() {
		return contenido;
	}

	
	public void llena() {
		contenido = capacidad;
	}
	
	public void vacia() {
		contenido = 0;
	}
	
	public void llenaDesde(Jarra j) {
		if(this == j) 															//Vamos a comprobar que no sean la misma jarra
		throw new RuntimeException("No se puede llenar una jarra desde sí misma");
		
		int trasvase = Math.min(this.capacidad-this.contenido, j.contenido);	//this. es la jarra que quiero llenar. j. es la jarra desde la que lleno.
		
		this.contenido += trasvase;	
		j.contenido -= trasvase;
	}
	
	@Override 													//Sirve para decirle a Java que sabemos que estamos redefiniendo el método "toStringde" la clase "Object" (Está relacionado con la herencia en Java) 
	public String toString() {									//Es el método toString. Tiene que llamarse así siempre
		return "J (" + capacidad + "," + contenido + ")"; 		//El enunciado nos dice que tiene que aparecer en pantalla J(capacidad, contenido), para ello encadenamos strings con "+"
	}
	
	

	
}
