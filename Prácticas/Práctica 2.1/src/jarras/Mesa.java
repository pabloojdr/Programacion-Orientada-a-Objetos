package jarras;

public class Mesa {
	private Jarra jarra1, jarra2;

	public Mesa(Jarra jarra1, Jarra jarra2) {
		if (jarra1 == jarra2)
			throw new RuntimeException("Las jarras tienen que ser distintas");
		this.jarra1 = jarra1;
		this.jarra2 = jarra2;
	}
	
	public Mesa(int capacidad1, int capacidad2) {
		jarra1 = new Jarra(capacidad1);
		jarra2 = new Jarra(capacidad2);
	}

	public int capacidad(int jarra) {
		int capacidad = -1; // Creamos una variable de tipo "int" debido a que el programa devuelve un int y
							// nosotros vamos a usar métodos de la clase Jarra (no se comportan como int(
		if (jarra == 1)
			capacidad = jarra1.capacidad();

		else if (jarra == 2)
			capacidad = jarra2.capacidad();

		else {
			throw new RuntimeException("Especifica una jarra válida (1 o 2)");
		}

		return capacidad;
	}

	public int contenido(int jarra) {
		int contenido = -1;
		if (jarra == 1)
			contenido = jarra1.contenido();

		else if (jarra == 2)
			contenido = jarra2.contenido();
		
		else {
			throw new RuntimeException("Especifica una jarra válida (1 o 2)");
		}
		return contenido;
	}

	public void llena(int jarra) {
		if(jarra == 1)
			jarra1.llena();
		
		else if(jarra == 2)
			jarra2.llena();
		
		else {
			throw new RuntimeException("Especifica una jarra válida (1 o 2)");
		}
	}
	
	public void vacia(int jarra) {
		if(jarra == 1)
			jarra1.vacia();
		
		else if(jarra == 2)
			jarra2.vacia();
		
		else {
			throw new RuntimeException("Especifica una jarra válida (1 o 2)");
		}
	}
	
	public void llenaDesde(int jarra) {
		if(jarra == 1)
			jarra2.llenaDesde(jarra1);
		
		else if(jarra == 2)
			jarra1.llenaDesde(jarra2);
		
		else {
			throw new RuntimeException("Especifica una jarra válida (1 o 2)");
		}
	}
	
	@Override	
	public String toString() {
		return "M(J(" + jarra1.capacidad() + "," + jarra1.contenido() + "), J(" + jarra2.capacidad() + "," + jarra2.contenido() + "))";	
	}
}
