package datos;

public class DatosException extends RuntimeException { // RuntimeException ==> No comprobada Para comprobada se usa Exception
	
	public DatosException() {
		super();
	}

	public DatosException(String s) {
		super(s);
	}
}
